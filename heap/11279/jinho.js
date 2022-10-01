const fs = require('fs');
const input = fs.readFileSync('a.txt').toString().trim().split('\n');

const N = parseInt(input[0]);
const data = input.slice(1, input.lastIndexOf('0') + 1).map(e => parseInt(e));

const result = [];

const switchOnNewElement = (arr, idx) => {
    if (idx === 1) return;
    if ( idx % 2 === 0 ){
        if ( arr[idx/2] < arr[idx] ){
            const tmp = arr[idx/2];
            arr[idx/2] = arr[idx];
            arr[idx] = tmp;
            return switchOnNewElement(arr, idx/2);
        }
    }   else if (idx % 2 === 1){
        if ( arr[(idx-1)/2] < arr[idx] ){
            const tmp = arr[(idx-1)/2];
            arr[(idx-1)/2]  = arr[idx];
            arr[idx] = tmp;
            return switchOnNewElement(arr, (idx-1)/2)
        }
    }
}

const alignLeftNodes = (arr, index) => {
    const tmp = arr[index];
    arr[index] = arr[index*2];
    arr[index*2] = tmp;
}

const switchOnDeleteElement = (arr, index) => {
    // no baby exists; 
    // console.log(index);
    // console.log(idx);
    if (index*2 > idx-1){
        // console.log("returned 1");
        return;
    }
    // only left baby node exists;
    if (index*2 + 1> idx-1 && arr[index*2] > arr[index]){
        // console.log("returned 2");
        alignLeftNodes(arr, index);
        return;
    }   
    // when both baby nodes exist;
    
    const maxBaby = Math.max(arr[index*2], arr[index*2+1]);
    
    // console.log(arr);
    // console.log(arr[index*2]);
    // console.log(arr[index*2 +1])
    if (arr[index] < maxBaby && arr[index*2] === maxBaby){
        arr[index*2] = arr[index];
        arr[index] = maxBaby;
        return switchOnDeleteElement(arr, index*2);
    }   else if (arr[index] < maxBaby) {
        arr[index*2+1] = arr[index];
        arr[index] = maxBaby;
        return switchOnDeleteElement(arr, index*2 + 1);
    }   else {
        return;
    }
    
}

// i : while loop index
let i=0;
// idx : length of maxHeap
let idx = 1;
const maxHeap = [0];
while ( i < data.length ){

    if (data[i] === 0 && maxHeap.length < 2){
        result.push(0);
    }   
    else if (data[i] === 0){
        result.push(maxHeap[1]);
        maxHeap.length === 2 ? maxHeap.pop() : maxHeap[1] = maxHeap.pop();
        
        idx--;
        switchOnDeleteElement(maxHeap, 1);
    }   
    else {
        maxHeap.push(data[i]);
        switchOnNewElement(maxHeap, idx);
        idx++;
    }
    
    i++;
}
console.log(result.join('\n'));

const fs = require('fs');
const input = fs.readFileSync('a.txt').toString().trim().split('\n');

const N = parseInt(input[0]);
const data = input.slice(1, input.lastIndexOf('0') + 1).map(e => parseInt(e));
// console.log(data);
const result = [];


const switchOnNewElement = (arr, idx) => {
    if (idx === 1) return;
    if ( idx % 2 === 0 ){
        if ( Math.abs(arr[idx/2]) > Math.abs(arr[idx]) || ( Math.abs(arr[idx/2]) === Math.abs(arr[idx]) && arr[idx/2] > arr[idx] )){
            const tmp = arr[idx/2];
            arr[idx/2] = arr[idx];
            arr[idx] = tmp;
            return switchOnNewElement(arr, idx/2);
        }
    }   else if (idx % 2 === 1){
        if ( Math.abs(arr[(idx-1)/2]) > Math.abs(arr[idx]) || (Math.abs(arr[(idx-1)/2]) === Math.abs(arr[idx]) && arr[(idx-1)/2] > arr[idx])){
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

const alignRightNodes = (arr, index) => {
    const tmp = arr[index];
    arr[index] = arr[index*2+1];
    arr[index*2+1] = tmp;
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
    if (index*2 + 1> idx-1 && Math.abs(arr[index*2]) < Math.abs(arr[index])){
        // console.log("returned 2");
        alignLeftNodes(arr, index);
        return;
    }   
    if (index*2 + 1 > idx-1 && (Math.abs(arr[index*2]) === Math.abs(arr[index]) && arr[index] > arr[index*2])){
        alignLeftNodes(arr, index);
        return;
    }
    // when both baby nodes exist;
    
    const minBaby = Math.min(Math.abs(arr[index*2]), Math.abs(arr[index*2+1]));
    
    // 좌우 노드의 절댓값이 같은 상황
    if (Math.abs(arr[2*index]) === Math.abs(arr[index*2+1])){
        if (Math.abs(arr[index]) < minBaby) return;
        if ( arr[2*index] === arr[2*index+1] && ( Math.abs(arr[index]) > minBaby || Math.abs(arr[index]) === minBaby && arr[index] > minBaby)){
            const tmp = arr[index*2];
            arr[index*2] = arr[index];
            arr[index] = tmp;
            return switchOnDeleteElement(arr, index*2);
        }   else if ( arr[2*index] > arr[2*index+1] && Math.abs(arr[index]) >= Math.abs(arr[2*index+1])){
            const tmp = arr[2*index+1];
            arr[2*index+1] = arr[index];
            arr[index] = tmp;
            return switchOnDeleteElement(arr, index*2+1);
        }   else if (arr[2*index] < arr[2*index+1] && Math.abs(arr[index]) >= Math.abs(arr[2*index])){
            const tmp = arr[2*index];
            arr[2*index] = arr[index];
            arr[index] = tmp;
            return switchOnDeleteElement(arr, index*2);
        }
        
    }
    if ((Math.abs(arr[index]) > minBaby && Math.abs(arr[index*2]) === minBaby ) || (Math.abs(arr[index]) === minBaby && Math.abs(arr[index*2]) === minBaby && arr[index] > arr[index*2]) ){
        const tmp = arr[index*2];
        arr[index*2] = arr[index];
        arr[index] = tmp;
        return switchOnDeleteElement(arr, index*2);
    }   else if ((Math.abs(arr[index]) > minBaby && Math.abs(arr[index*2+1]) === minBaby ) || (Math.abs(arr[index]) === minBaby && Math.abs(arr[index*2+1]) === minBaby && arr[index] > arr[index*2+1] )) {
        const tmp = arr[index*2+1];
        arr[index*2+1] = arr[index];
        arr[index] = tmp;
        return switchOnDeleteElement(arr, index*2 + 1);
    }   else {
        return;
    }
    
}

// i : while loop index
let i=0;
// idx : length of minHeap
let idx = 1;
const minHeap = [0];
while ( i < data.length ){

    if (data[i] === 0 && minHeap.length < 2){
        result.push(0);
    }   
    else if (data[i] === 0){
        result.push(minHeap[1]);
        minHeap.length === 2 ? minHeap.pop() : minHeap[1] = minHeap.pop();
        
        idx--;
        switchOnDeleteElement(minHeap, 1);
    }   
    else {
        minHeap.push(data[i]);
        switchOnNewElement(minHeap, idx);
        idx++;
    }
    
    i++;
}
console.log(result.join('\n'));

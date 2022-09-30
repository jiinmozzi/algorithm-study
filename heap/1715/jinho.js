const fs = require('fs');
const input = fs.readFileSync('a.txt').toString().trim().split('\n');

const N = parseInt(input[0]);
const data = input.map(Number);

const minHeap = [-1];

const switchOnInsert = (arr, idx) => {
    if (parseInt(idx/2) === 0)  return ;
    if (arr[parseInt(idx/2)] > arr[idx]){
        const tmp = arr[parseInt(idx/2)];
        arr[parseInt(idx/2)] = arr[idx];
        arr[idx] = tmp;
        return switchOnInsert(arr, parseInt(idx/2));
    }
    return ;
}

let i=1;
// making inital min heap;
while(i < N+1){
    minHeap.push(data[i]);
    switchOnInsert(minHeap, i);
    i++;
}

// process to get result
const sortingMinHeaps = (arr, idx) => {
    
    if ( !arr[2*idx] )  return;

    if ( !arr[2*idx+1]){
        if (arr[2*idx] < arr[idx]){
            const tmp = arr[idx]
            arr[idx] = arr[2*idx];
            arr[2*idx] = tmp;
        }
        return;
    }
    const min = Math.min(arr[2*idx], arr[2*idx+1]);

    if (arr[2*idx] === min){
        if (arr[idx] > min){
            const tmp = arr[2*idx];
            arr[2*idx] = arr[idx];
            arr[idx] = tmp;
            return sortingMinHeaps(arr, 2*idx);
        }
    }   else {
        if (arr[idx] > min){
            const tmp = arr[2*idx+1];
            arr[2*idx+1] = arr[idx];
            arr[idx] = tmp;
            return sortingMinHeaps(arr, 2*idx + 1);
        }
    }
    
}
let result = 0;
while (minHeap.length > 3){
    let sum = minHeap[1];
    minHeap[1] = minHeap.pop();
    sortingMinHeaps(minHeap, 1);
    minHeap[1] += sum;
    result += minHeap[1];
    sortingMinHeaps(minHeap, 1);
}
if (minHeap.length < 3){
    console.log(0);
}   else {
    console.log(minHeap[1] + minHeap[2] + result);
}

const fs = require('fs');
const input = fs.readFileSync('a.txt').toString().trim().split('\n');

const N = parseInt(input[0]);
const data = input[1].split(' ').map(e => parseInt(e));

const answer = [data[0]];

const binarySearch = ( arr, elem ) => {
    let left = 0;
    let right = arr.length - 1;
    let idx;
    while( left <= right ){
        let mid = Math.floor((left + right) / 2);
        if ( arr[mid] === elem ){
            return -1;
        }   
        else if ( arr[mid] < elem ) {
            left = mid + 1;
        }   
        else if ( arr[mid] > elem ) {
            right = mid - 1;
        }
    }
    arr[left] = elem;
}

for (let i=1; i<data.length; i++){
    if ( data[i] > answer[answer.length -1] ){
        answer.push(data[i]);
    }   
    else if ( data[i] < answer[answer.length - 1] ){
        binarySearch(answer, data[i]);
    }
}

console.log(answer.length)
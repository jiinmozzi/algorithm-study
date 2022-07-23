const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();
const N = parseInt(input);

const arr = [-1, -1, -1, 1, -1, 1, 2, -1, 2, 3, 2, 3, 4, 3, 4, 3];
const remainder = N%15;

if (N <= 15){
    console.log(arr[N]); 
}   else {
    if (remainder===0 || remainder === 5 || remainder === 10){
        console.log(N/5);
    }   else if(remainder === 1 || remainder === 6 || remainder === 11){
        console.log(2 + (N-6)/5);
    }   else if (remainder === 2 || remainder === 7 || remainder === 12){
        console.log(4 + (N-12)/5);
    }   else if (remainder === 3 || remainder === 8 || remainder === 13){
        console.log(1 + (N-3)/5);
    }    else if (remainder === 4 || remainder === 9 || remainder === 14){
        console.log(3 + (N-9)/5);
    }   else {
        console.log(-1)   
    }
}
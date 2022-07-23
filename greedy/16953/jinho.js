const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');

const N = parseInt(input[0]);
let M = parseInt(input[1]);

let count = 0;
while (1){
    if (M < N){
        console.log(-1);
        break;
    }   else if (M === N){
        console.log(count+1);
        break;
    }

    if ( M % 10 === 1 ){
        M = Math.floor(M/10);
        count += 1;
    }   else if (M % 2 === 0){
        M /= 2;
        count += 1;
    }   else {
        console.log(-1);
        break;
    }
}
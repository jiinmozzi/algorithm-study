const fs = require('fs');
const input = fs.readFileSync('a.txt').toString().trim().split('\n');

const N = parseInt(input[0]);
const M = parseInt(input[1]);

let left = 1;
let right = M;

const countLessOrEqual = (x) => {
    let cnt = 0;
    for (let i=1; i<N+1; i++){
        cnt += Math.min( Math.floor(x/i), N ) ;
    }
    return cnt;
}
while (left < right){
    let mid =  Math.floor((left+right)/2);
    // console.log("mid : ", mid);
    
    const count = countLessOrEqual(mid);
    // console.log("count : ", count);
    if ( M > count ){
        left = mid + 1;
    }   else {
        right = mid;
    }
}

console.log(left);
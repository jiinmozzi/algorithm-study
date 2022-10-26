const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const M = parseInt(input[0]);
const N = parseInt(input[2]);

const data = input[1].split(' ');
const comparison = input[3].split(' ');

const obj = {};
const answer = [];
for(let i=0; i<M; i++){
    if (!obj[data[i]]){
        obj[data[i]] = 1;
    }
}

for (let i=0; i<N; i++){
    if (obj[comparison[i]]){
        answer.push(1);
    }   else {
        answer.push(0);
    }
}

console.log(answer.join('\n'));
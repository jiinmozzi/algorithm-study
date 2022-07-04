const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = parseInt(input[0]);
const data = input.slice(1).map(e => parseInt(e));

const res = [];
const operators = [];

let isPlausible = true;
let num = 1;
while(data.length!==0){
    if(res.length === 0 && data.length === N){
        res.push(num++);
        operators.push("+");
        continue;
    }
    if(res[res.length-1] > data[0]){
        isPlausible = false;
        break;
    }   else if(res[res.length-1]===data[0]){
        res.pop();
        data.shift();
        operators.push("-");
    }   else {
        res.push(num++);
        operators.push("+");
    }
}

if(isPlausible === true){
    console.log(operators.join('\n'));
}   else {
    console.log('NO');
}
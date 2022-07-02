const fs = require('fs');
const input = fs.readFileSync('a.txt').toString().trim().split('\n');

const N = input[0].split(' ')[0];
const data = input.slice(1);
const stack = {}
let count = 0;
for (let i=0; i<data.length; i++){
    const line = parseInt(data[i].split(' ')[0]);
    const flat = parseInt(data[i].split(' ')[1]);

    if (stack[line] === undefined){
        stack[line] = [flat];
        count++;
    }   else if(stack[line][stack[line].length -1] > flat){
        while (stack[line][stack[line].length-1] > flat){
            stack[line].pop();
            count++;
        }
        if (stack[line][stack[line].length-1] === flat){
            continue;
        }   else {
            stack[line].push(flat);
            count++;
        }
    }   else if (stack[line][stack[line].length -1] < flat){
        stack[line].push(flat);
        count++;
    }   else if (stack[line][stack[line].length-1] === flat){
        continue;
    }
}
console.log(count);

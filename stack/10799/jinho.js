const fs = require('fs');
let input = fs.readFileSync('a.txt').toString().trim();

const parenthesisNumber = input.split("()").length -1;
const totalLines = (input.length - parenthesisNumber * 2) / 2;

let result = 0;
let count = 0;

let cnt = parenthesisNumber
while(cnt--){
    const idx = input.indexOf("()");
    for(let i=0; i<idx; i++){
        if (input[i] === '('){
            count += 1;
        }   else {
            count -= 1;;
        }
    }
    result += count;
    input = input.slice(idx+2);
}
console.log(result + totalLines);
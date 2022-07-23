const fs = require('fs');
const input = fs.readFileSync('a.txt').toString().trim().split('\n');

const N = parseInt(input[0]);

const arr = [];
for (let i=1; i<N+1; i++){
    arr.push(input[i].split(" ").map(e => parseInt(e)));
}

arr.sort((a,b) => a[0] - b[0]);

const result = [];
for (let i=0; i<N; i++){
    result.push(0);
}
result[N-1] = 1;

for (let i=N-2; i>=0; i--){
    for (let j=i+1; j<N; j++){
        if (arr[i][1] <= arr[j][0]){
            const tmp = result.slice(j);
            result[i] = tmp.reduce((p,c) => Math.max(p,c), -1) + 1;
            break;
        }
    }    
}

console.log(result.reduce((p,c) => Math.max(p,c), -1));

// 메모리 초과 
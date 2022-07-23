const fs = require('fs');
const input = fs.readFileSync('a.txt').toString().trim().split('\n'); 

const N = parseInt(input[0]);
const M = parseInt(input[1]);

const result = [1];
const matrix = [];

for (let i=0; i<N+1; i++){
    const arr = [];
    for (let j=0; j<N+1; j++){
        arr.push(0);
    }
    matrix.push(arr);
}

for (let i=2; i<M+2; i++){
    const [x, y] = input[i].split(' ').map(e => parseInt(e));
    matrix[x][y] = 1;
    matrix[y][x] = 1;
}

const bfs = (_matrix, idx) => {
    
    let done = true;
    const needsBfs = [];
    for (let i=0; i<N+1; i++){
        if (_matrix[idx][i] === 1 && result.indexOf(i) === -1){
            needsBfs.push(i)
            result.push(i);
            done = false;
        }
    }
    
    if (done === true){
        return;
    }   
    for (let i=0; i<needsBfs.length; i++){
        bfs(_matrix, needsBfs[i]);
    }
}

bfs(matrix, 1);
console.log(result.length -1);

//success
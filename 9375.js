const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let data = input.slice(1);

while(data.length>0){
    const N = parseInt(data[0])
    const obj = {};
    for (let i=1; i<N+1; i++){
        const clothing = data[i].split(' ')[0];
        const type = data[i].split(' ')[1];
        if (obj[type] === undefined){
            obj[type] = [clothing];
        }   else {
            obj[type].push(clothing)
        }
    }
    console.log(obj);
    
    const arr = Object.values(obj).map(e => e.length + 1 );
    const result = arr.reduce((p,c) => p*c, 1);
    console.log(result-1);
    data = data.slice(N+1, data.length);
}
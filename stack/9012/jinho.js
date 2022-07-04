const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const datas = input.slice(1).map(e => e.trim());

for(let i=0; i<datas.length; i++){
    let data = datas[i];
    let isVPS = true;
    while(data.length){
        if(data.length===1){
            isVPS = false;
            break;
        }
        const idx = data.indexOf('()');
        if(data.length>=2 && idx===-1){
            isVPS = false;
            break;
        }
        data = data.split('');
        data.splice(idx, 2);
        data = data.join('')
    }
    if(isVPS) console.log('YES');
    else console.log('NO');
}
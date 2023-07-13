function solution(arr) {
    var answer = [];
    for(let i = 0; i < arr.length; i++) {
        var now = arr[i];
        if(now >= 50 && now % 2 == 0){
            answer.push(now / 2);
        }else if(now <= 50 && now % 2 == 1) {
            answer.push(now * 2);
        }else answer.push(now);
    }
    return answer;
}
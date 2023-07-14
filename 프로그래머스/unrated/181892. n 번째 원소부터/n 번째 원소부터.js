function solution(num_list, n) {
    var result = [];
    for(var i = n - 1; i < num_list.length; i++) {
        result.push(num_list[i]);
    }
    return result;
}
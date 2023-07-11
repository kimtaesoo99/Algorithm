function solution(num_list) {
    var mulit = num_list.reduce((a, b) => a * b, 1);
    var sum = (num_list.reduce((a, b) => a + b, 0))**2;
    return mulit > sum ? 0 : 1;
}
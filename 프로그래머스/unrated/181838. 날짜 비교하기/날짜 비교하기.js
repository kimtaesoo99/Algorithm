function solution(date1, date2) {
    let d1 = new Date(date1.join('-'));
    let d2 = new Date(date2.join('-'));
    return d1 < d2 ? 1 : 0;
}
function solution(a, b) {
    let f = parseInt(a.toString() + b.toString());
    let s = 2 * a * b;
    return f > s ? f : s;
}
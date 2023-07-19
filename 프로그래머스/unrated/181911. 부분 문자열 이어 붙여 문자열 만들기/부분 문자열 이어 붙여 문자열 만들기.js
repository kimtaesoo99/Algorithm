function solution(my_strings, parts) {
    let str = "";
    for(let i = 0; i < parts.length; i++) {
        let slice = parts[i];
        str += my_strings[i].slice(slice[0], slice[1] + 1);
    }
    return str;
}
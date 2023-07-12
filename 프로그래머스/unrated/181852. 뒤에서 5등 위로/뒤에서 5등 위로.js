function solution(num_list) {
  var result = new Array(num_list.length - 5 > 0 ? num_list.length - 5 : 1);
  num_list.sort(function(a, b) { return a - b; });
  for (var i = 5; i < num_list.length; i++) {
    result[i - 5] = num_list[i];
  }
  return result;
}

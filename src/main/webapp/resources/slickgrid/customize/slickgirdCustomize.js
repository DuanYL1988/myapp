/*
 *
 */
var numberOfItems = 0, items = [], indices, isAsc = true, currentSortCol = { id: "title" }, i;

function sort(data,currentSortCol){
  // 数据件数
  var numberOfItems = data.length;
  var items = [], indices, isAsc = true,i;
  
  for (i = numberOfItems; i-- > 0;) {
    items[i] = i;
    data[i] = {
      title: "Task ".concat(i + 1)
    };
  }
}

function randomize(items) {
  var randomItems = $.extend(true, null, items), randomIndex, temp, index;
  for (index = items.length; index-- > 0;) {
    randomIndex = Math.round(Math.random() * items.length - 1);
    if (randomIndex > -1) {
      temp = randomItems[randomIndex];
      randomItems[randomIndex] = randomItems[index];
      randomItems[index] = temp;
    }
  }
  return randomItems;
}
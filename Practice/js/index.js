"use strict";
/*安装，需要先安装node.js
npm install --g typescript
让vscode编译ts为js，使用代码 tsc --init
创建了tsconfig.json文件，点开修改输出"outDir": "./js",
终端-运行任务-监视，形成js文件
*/
function getData() {
}
var str = "helloTS";
console.log(str);
//语法不同，数据类型也不同
/*数据类型有boolean*/
var flag = true;
//number 类型
var num = 123;
//string类型
var stri = "helloWorld";
//array，有两种定义方式
//1
var arr = [1, 2, 3, 4];
console.log(arr);
//2
var arr2 = [4, 3, 2, 1];
console.log(arr2);
//重点！！！！！！
//元组类型 tuple， array的一种，类似于arraylist，可同时加入number与string
var arr3 = [123, 'This is tuple', 345, 'this is tuple too'];
console.log(arr3);
//枚举类型 enum，类似于坐标，以数字代表非数字或某种状态，如: 1 success 0 error
var Flag;
(function (Flag) {
    Flag[Flag["success"] = 1] = "success";
    Flag[Flag["error"] = 2] = "error";
})(Flag || (Flag = {}));
;
var s = Flag.success;
console.log(s);
var color;
(function (color) {
    color[color["blue"] = 1] = "blue";
    color[color["red"] = 2] = "red";
    color[color["green"] = 3] = "green";
    color[color["black"] = 4] = "black";
})(color || (color = {}));
var c = color.black;
console.log(c);
/*enum bread{whiteBread,frenchBread,cake,muffin}
let b:bread=bread.whiteBread
console.log(b);*/
//如果不赋值，自动按index值赋值，如果中途赋值，后一数字会从前面赋值的数字开始+1
var bread;
(function (bread) {
    bread[bread["whiteBread"] = 0] = "whiteBread";
    bread[bread["frenchBread"] = 1002] = "frenchBread";
    bread[bread["cake"] = 1003] = "cake";
    bread[bread["muffin"] = 1004] = "muffin";
})(bread || (bread = {}));
var b = bread.cake;
console.log(b);
var computer;
(function (computer) {
    computer[computer["laptop"] = 1] = "laptop";
    computer[computer["pc"] = 3] = "pc";
})(computer || (computer = {}));
var com = computer.laptop;
console.log(com);
//any类型
var numAny = 123;
numAny = 'str';
var obox = document.getElementById('box');
obox.style.color = 'green';
//undefined报错时使用(定义未赋值)
var numnum;
console.log(numnum);
var numnum2;
numnum2 = 123; //显示123 如果赋值就会显示undefined
//null也同理
var numnum3;
//void方法类，js中就是function xxx(){},ts中可使用为：()=>{something}或()=>something
function run() {
    console.log('run');
}
run();
//ts中需要return的方法可写为：
function run2() {
    return 2;
}
var valueReturn = run2();
console.log(valueReturn);
//never类型，包括null和Undefined等从不会出现的值
/*var aa:never //Lambda表达式 自调用匿名函数？
aa=(() =>{
 throw new Error('错误')
})()*/
//方法上比以往多出或者不同的用法
//匿名函数
var funfun = function () {
    return 250;
};
//alert(funfun());
function getInfo(name, age) {
    return name + "----" + age;
}
//alert(getInfo('nanana',55))
//以上方法改为匿名函数：
var GetInfo = function (name, age) {
    return name + ": " + age;
};
console.log(GetInfo('nanana', 88));
var testInfo = function () {
    console.log('testInfo');
};
testInfo();
//ts方法中的参数可部分使用：带问号的表示可有可无
function getGet(name, age) {
    if (age) {
        return name + ": " + age;
    }
    else {
        return name + ': age unknown';
    }
}
console.log(getGet('nanana'));
//还能设置默认参数
function getGet2(name, age) {
    if (age === void 0) { age = 20; }
    return name + ": " + age;
}
console.log(getGet2('nini'));
//数组作为参数,使用三点运算符代表传入多个参数
function sum() {
    var result = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        result[_i] = arguments[_i];
    }
    var sum = 0;
    for (var i = 0; i < result.length; i++) {
        sum += result[i];
    }
    return sum;
}
console.log(sum(4, 6, 7, 87, 32));
function getFun(str) {
    if (typeof str === 'string') {
        return 'Name: ' + str;
    }
    else {
        return 'data: ' + str;
    }
}
console.log(getFun('as'));
console.log(getFun(20));
//箭头函数
//settimeout是一个build in function，可用于倒计时
setTimeout(function () {
    obox.innerHTML = '<h1>runrunrunrunrunrun!</h1>';
}, 1000);
setTimeout(function () {
    obox.style.color = 'red';
}, 1000);
//ts中也可使用class
function Person() {
    this.name = 'namename';
    this.age = 20;
    this.run = function () {
        obox.innerHTML = this.name + ' ' + this.age;
    };
}

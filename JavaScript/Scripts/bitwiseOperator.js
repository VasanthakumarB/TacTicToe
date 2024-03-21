/*
bitwise AND Assignment &=
bitwise OR Assignment |=
bitwise Not Assignment ~
bitwise XOR Assignment ^
Left Shift Assignment(<<=)
Right Shift Assignment(>>=) 
unSigned right shift Assignment (>>>=)
*/
let a=3;
let b=2;
console.log(a&b);

a=5;
b=2;
console.log(a|b);
//0101
//0010
//0111

a=10;
b=12;
console.log(a>>b);
//1010
//0010
//0011
a=10;
b=2;
console.log(a<<b);
//1010
alert("Nullish Collescuing operator(??)");
console.log("Nullish Collescuing operator(??)");
const c=null??'No Value';
const d=null??45;
console.log(c);
console.log(d);
const user={"fname":"Vasanthakumar"};
user.city??="Ramanathapuram";
console.log(user.city);
console.table(user);

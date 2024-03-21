console.log("Welcome");
let fname="Vasanth";
console.log(fname?fname:"no Name");
function welcome(fname){
    fname=fname?fname:"No Name";
    console.log("Welcome to "+fname);
}
welcome();
welcome(null);
welcome("kumar");

const user={"fname":"kumar",Age:24};
console.table(user);

const greeting=(user)=>{
    return "Welcome Vasantha"+user.fname;
}
console.log(greeting(user));

const avg=95;
const grade=avg>=90? "Grade A":avg>=80? "Grade B":"Grade C";
console.log(grade);
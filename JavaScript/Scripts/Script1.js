const elseIfstate=()=>{
    let avg=document.getElementsByClassName("txt");
    console.log(avg[0].value);
    const a=avg[0].value;
    if(a>90){
        alert("Grade A");
    }else if(a>=80 && a<=90){
        alert("Grade B");
    }else if(a>=70 && a<80){
        alert("Grade C");
    }else{
        alert("Grade F");
    }
    return false;
}
const btn=document.getElementsByClassName('btn')[0];
const navbar=document.getElementsByClassName('box')[0];

btn.addEventListener('click',()=>{
    navbar.classList.toggle('active');
});
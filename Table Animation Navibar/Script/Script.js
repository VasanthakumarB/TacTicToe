document.addEventListener('DOMContentLoaded',()=>{
    const sideNav=document.querySelector('.side-nav');
    const btnnav=document.querySelector('#btnname');
    const overlayScreen=document.querySelector('.nav-overlay');
    btnnav.addEventListener('click',()=>{
        sideNav.classList.add('open');
    });
    overlayScreen.addEventListener('click',()=>{
        sideNav.classList.remove('open');
    });
});
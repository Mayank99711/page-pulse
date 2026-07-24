async function analyzeWebsite(){

const url=document.getElementById("url").value;

const loader=document.getElementById("loader");

const result=document.getElementById("result");

loader.style.display="block";

result.innerHTML="";

try{

const response=await fetch("/api/analyze",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({
url:url
})

});

const data=await response.json();

loader.style.display="none";

if(data.error){

result.innerHTML="<h3>"+data.error+"</h3>";

return;

}

let seoClass="good";

if(data.seoScore<80)
seoClass="average";

if(data.seoScore<60)
seoClass="bad";

result.innerHTML=`

<div class="card">

<div class="row">

<b>HTTP Status</b>

<span>${data.httpStatus}</span>

</div>

<div class="row">

<b>Response Time</b>

<span>${data.responseTime} ms</span>

</div>

<div class="row">

<b>Page Title</b>

<span>${data.title}</span>

</div>

<div class="row">

<b>Meta Description</b>

<span>${data.metaDescription}</span>

</div>

<div class="row">

<b>H1 Count</b>

<span>${data.h1Count}</span>

</div>

<div class="row">

<b>Missing ALT Images</b>

<span>${data.missingAltImages}</span>

</div>

<div class="row">

<b>Word Count</b>

<span>${data.wordCount}</span>

</div>

<div class="row">

<b>SEO Score</b>

<span class="${seoClass}">

${data.seoScore}/100

</span>

</div>

</div>

`;

}

catch(e){

loader.style.display="none";

result.innerHTML="<h2>Unable to connect to server.</h2>";

}

}
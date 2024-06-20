const name = document.getElementById('name')
const surname = document.getElementById('surname')
const indeks = document.getElementById('indeks')

if(name.value==null || name.value==''){
    alert("Prazno ime studenta")
    return
}

if(surname.value==null || surname.value==''){
    alert("Prazno prezimeime studenta")
    return
}

if(indeks.value==null || indeks.value==''){
    alert("indeks prazan")
    return
}

fetch('http://localhost:8000/api/student' ,{
    metod:'POST',
    headers:{
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        name:name.value,
        surname: surname.value,
         indeks: indeks.value
    })
})
.then(rsp=>{
    if(rsp.ok){
        window.location.href='./indeks.html'
        return
    }
    alert('Izmena nije uspela')
})
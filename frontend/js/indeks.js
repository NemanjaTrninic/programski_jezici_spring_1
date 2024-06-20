const table = document.getElementById('table')
const template = document.getElementById('student')
const searchTitle = document.getElementById('search-title')

if (searchParam != null && searchParam != ''){
    searchTitle.innerText= "Pretraga Studenata"
    fetchStudents('/indeks/' + searchParam)

} else{ 
    searchTitle.innerText= "Lista Studenata"
    fetchStudents()
}
    


    function fetchStudents(url=''){

        fetch(`http://localhost:8000/student${url}`)
        .then(rsp => rsp.json())
        .then(data => {
            if (data.lenght == 0){
                alert('Student nije pronadjen')
                fetchStudents()
                return
            }

            data.forEach(student => {
                const copy = template.content.cloneNode(true)
                copy.querySelector('.id').innerText = student.id
                copy.querySelector('.name').innerText = student.name
                copy.querySelector('.surname').innerText = student.surname
                copy.querySelector('.indeks').innerText = student.indeks
                copy.querySelector('.created').innerText = formatDate(student.createdAt)
                copy.querySelector('.updated').innerText = formatDate(student.updatedAt)
                copy.querySelector('.edit').href = `./edit.html?id=${student.id}`
                table.appendChild(copy)
            
            })
        })


    }

    

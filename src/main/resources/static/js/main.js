var showedDiv;

const showHideFunc = (id) => {
    const x = document.getElementById(id)
    if (!x.classList.contains("visibleA")) {
        if (showedDiv !== undefined) {
            showedDiv.classList.remove("visibleA")
            showedDiv.classList.add("hiddenA")
            showedDiv.style.display = "none"
        }
        showedDiv = x;
        x.style.display = "flex"
        x.classList.remove("hiddenA")
        x.classList.add("visibleA")
    } else {
        x.classList.remove("visibleA")
        x.classList.add("hiddenA")
        setTimeout(() => x.style.display = "none", 500)
    }
}

document.getElementById("for_about_button").addEventListener("click", () => showHideFunc("for_about"))
document.getElementById("for_reader_button").addEventListener("click", () => showHideFunc("for_reader"))
document.getElementById("for_author_button").addEventListener("click", () => showHideFunc("for_author"))

document.getElementById("for_about").style.display = "none"
document.getElementById("for_reader").style.display = "none"
document.getElementById("for_author").style.display = "none"
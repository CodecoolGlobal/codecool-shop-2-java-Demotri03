//get all cart buttons
console.warn("asd")
function initEventListeners() {
    const cartButtons = document.getElementsByClassName("add-to-cart");
    //iterate over cart buttons
    for (let i = 0; i < cartButtons.length; i++) {
        cartButtons[i].addEventListener("click",async function(){
            await apiGET("/cart/add?productId="+cartButtons[i].getAttribute("id"))
    })}

}


async function apiGET(url) {
    const response = await fetch(url, {method: "GET"});
}

function main() {
    initEventListeners();
}

main()
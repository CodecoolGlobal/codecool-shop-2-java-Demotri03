async function apiGET(url) {
    const response = await fetch(url, {method: "GET"});
}

function initEventListeners() {
const cartButtons = document.getElementsByClassName("cart-review");
    //iterate over cart buttons
    for (let i = 0; i < cartButtons.length; i++) {
        cartButtons[i].addEventListener("click",async function(){
            await apiGET("/cart/update?productId="+cartButtons[i].getAttribute("id")+ "&direction=" + cartButtons[i].dataset.direction)
            location.reload()
            })
        console.log("/cart/update?productId="+cartButtons[i].getAttribute("id")+ "&direction=" + cartButtons[i].dataset.direction)

}}

function main() {
    initEventListeners();
}

main()
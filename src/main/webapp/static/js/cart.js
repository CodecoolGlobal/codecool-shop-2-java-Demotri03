//get all cart buttons
function initEventListeners() {
    const cartButtons = document.getElementsByClassName("add-to-cart");
    //iterate over cart buttons
    for (let i = 0; i < cartButtons.length; i++) {
        cartButtons[i].addEventListener("click",async function(){
            await apiGET("/cart/add?productId="+cartButtons[i].getAttribute("id"))
            const cart = document.querySelector(".cart")
            cart.dataset.count ++
            document.querySelector("#cart-counter").innerText = cart.dataset.count

    })}

}


async function apiGET(url) {
    const response = await fetch(url, {method: "GET"});
}

function main() {
    initEventListeners();
}

main()
//get all cart buttons
console.warn("asd")
function initEventListeners() {
    const cartButtons = document.getElementsByClassName("add-to-cart");
    console.log(cartButtons);
    //iterate over cart buttons
    for (let i = 0; i < cartButtons.length; i++) {
        debugger;
        cartButtons[i].addEventListener("click",async function(){
            await apiGET("/cart/add?productId="+cartButtons[i].getAttribute("id"))
    })}

    // cartButtons.forEach(cartButton => {
    //     cartButton.addEventListener("click",async function(){
    //         await apiGET("/cart/add?productId="+cartButton.getAttribute("id"));
    //
    //     } );
    // })

}


async function apiGET(url) {
    const response = await fetch(url, {method: "GET"});
    // return await response.json();
}

function main() {
    initEventListeners();
}

main()
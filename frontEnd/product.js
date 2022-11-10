let productList=[
    {img:"https://cdn.shopify.com/s/files/1/0244/8248/0177/collections/artichoke_large.jpg?v=1575589763",name:"Artichoke",price:200},
    {img:"https://cdn.shopify.com/s/files/1/0244/8248/0177/products/12_large.jpg?v=1574985220",name:"Arugula",price:300},

    {img:"https://cdn.shopify.com/s/files/1/0244/8248/0177/products/23_large.jpg?v=1576373897",name:"Artichoke",price:200},

    {img:"https://cdn.shopify.com/s/files/1/0244/8248/0177/collections/Brusselsfront_large.jpg?v=1575916835",name:"Artichoke",price:200},


];

productList.map(function (elem) {
    var box = document.createElement("div");
    box.setAttribute("class","box");
    var Imgbox = document.createElement("div");
    Imgbox.setAttribute("class","Imgbox");
    var img = document.createElement("img");
    img.src = elem.img;
    Imgbox.append(img)
    var name = document.createElement("p");
    name.textContent = elem.name;

    var price = document.createElement("p");
    price.innerText ="Rs. "+ elem.price;

    var btn = document.createElement("button");
    btn.innerText = "Buy";
    btn.addEventListener("click", function () {
      addToCart(elem);
    });

    box.append(Imgbox, name, price, btn);

    document.querySelector("#product_map").append(box);
  });


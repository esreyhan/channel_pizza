(function(t){function e(e){for(var r,i,o=e[0],c=e[1],u=e[2],d=0,p=[];d<o.length;d++)i=o[d],Object.prototype.hasOwnProperty.call(n,i)&&n[i]&&p.push(n[i][0]),n[i]=0;for(r in c)Object.prototype.hasOwnProperty.call(c,r)&&(t[r]=c[r]);l&&l(e);while(p.length)p.shift()();return s.push.apply(s,u||[]),a()}function a(){for(var t,e=0;e<s.length;e++){for(var a=s[e],r=!0,o=1;o<a.length;o++){var c=a[o];0!==n[c]&&(r=!1)}r&&(s.splice(e--,1),t=i(i.s=a[0]))}return t}var r={},n={app:0},s=[];function i(e){if(r[e])return r[e].exports;var a=r[e]={i:e,l:!1,exports:{}};return t[e].call(a.exports,a,a.exports,i),a.l=!0,a.exports}i.m=t,i.c=r,i.d=function(t,e,a){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(i.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)i.d(a,r,function(e){return t[e]}.bind(null,r));return a},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],c=o.push.bind(o);o.push=e,o=o.slice();for(var u=0;u<o.length;u++)e(o[u]);var l=c;s.push([0,"chunk-vendors"]),a()})({0:function(t,e,a){t.exports=a("56d7")},"0c02":function(t,e,a){"use strict";a("d66a")},1771:function(t,e,a){var r={"./brand.png":"2a19","./californian.jpg":"3be5","./cocacola.jpeg":"46f4","./cokelight.jpg":"2fde","./deep-dish-pizza.jpg":"abc7","./detroit.jpg":"4189","./logo.png":"cf05","./neapolitan.jpg":"3234","./newyork.jpg":"7e2e","./sicilian.jpg":"e05b","./sparkling.jpeg":"2c56","./still.jpg":"d6b6","./turkish.jpg":"aaef"};function n(t){var e=s(t);return a(e)}function s(t){if(!a.o(r,t)){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}return r[t]}n.keys=function(){return Object.keys(r)},n.resolve=s,t.exports=n,n.id="1771"},"2a19":function(t,e,a){t.exports=a.p+"img/brand.95516d69.png"},"2c56":function(t,e,a){t.exports=a.p+"img/sparkling.616b0e71.jpeg"},"2fde":function(t,e,a){t.exports=a.p+"img/cokelight.81b18bd5.jpg"},3234:function(t,e,a){t.exports=a.p+"img/neapolitan.9ead4c1a.jpg"},"3be5":function(t,e,a){t.exports=a.p+"img/californian.18400e45.jpg"},4189:function(t,e,a){t.exports=a.p+"img/detroit.d2fad1e6.jpg"},"46f4":function(t,e,a){t.exports=a.p+"img/cocacola.3e9d8209.jpeg"},"48e4":function(t,e,a){"use strict";a("7f84")},"56d7":function(t,e,a){"use strict";a.r(e);var r={};a.r(r),a.d(r,"cartItemCount",(function(){return ht})),a.d(r,"total",(function(){return Ct})),a.d(r,"products",(function(){return bt}));var n={};a.r(n),a.d(n,"SET_PRODUCTS",(function(){return _t})),a.d(n,"SET_PRODUCT",(function(){return xt})),a.d(n,"ADD_TO_CART",(function(){return yt})),a.d(n,"SET_ORDER",(function(){return wt})),a.d(n,"CART_CLEAR",(function(){return Ot}));var s={};a.r(s),a.d(s,"getProducts",(function(){return jt})),a.d(s,"getProduct",(function(){return kt})),a.d(s,"addProductToCart",(function(){return Pt})),a.d(s,"addOrder",(function(){return St})),a.d(s,"cartClear",(function(){return $t}));a("e260"),a("e6cf"),a("cca6"),a("a79d");var i=a("2b0e"),o=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("AppHeader"),a("div",{staticClass:"container"},[a("router-view")],1)],1)},c=[],u=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("nav",{staticClass:"navbar navbar-expand-sm navbar-light navbar-jw"},[t._m(0),t._m(1),a("div",{staticClass:"collapse navbar-collapse",attrs:{id:"appnav"}},[a("div",{staticClass:"nav navbar-nav"},[a("router-link",{staticClass:"nav-item nav-link",staticStyle:{"margin-left":"20px"},attrs:{to:{name:"Home"},"active-class":"active",exact:""}},[t._v(" Home ")]),a("router-link",{staticClass:"nav-item nav-link",staticStyle:{"margin-left":"20px"},attrs:{to:{name:"ProductList"},"active-class":"active",exact:""}},[t._v(" Menu ")]),a("router-link",{staticClass:"nav-item nav-link",staticStyle:{"margin-left":"20px"},attrs:{to:{name:"Minicart"},"active-class":"active",exact:""}},[t._v(" Cart ")]),t.authenticated?a("span",{staticClass:"nav-item nav-link",staticStyle:{"margin-left":"20px"},attrs:{"active-class":"active",exact:""}},[t._v(" "+t._s(t.user)+" ")]):t._e(),t.authenticated?a("a",{staticClass:"nav-item nav-link",staticStyle:{"margin-left":"20px"},attrs:{id:"logOut",href:"#","active-class":"active",exact:""},on:{click:function(e){return t.logout()}}},[t._v(" Log Out ")]):[a("router-link",{staticClass:"nav-item nav-link",staticStyle:{"margin-left":"20px"},attrs:{to:{name:"Login"},"active-class":"active",exact:""}},[t._v(" Sign-in ")]),a("router-link",{staticClass:"nav-item nav-link",staticStyle:{"margin-left":"20px"},attrs:{to:{name:"Register"},"active-class":"active",exact:""}},[t._v(" Register ")])]],2)])])])},l=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("button",{staticClass:"navbar-toggler",attrs:{type:"button","data-toggle":"collapse","data-target":"#appnav","aria-controls":"appnav","aria-expanded":"false","aria-label":"Toggle navigation"}},[a("span",{staticClass:"navbar-toggler-icon"})])},function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("a",{staticClass:"navbar-brand",attrs:{href:"#"}},[r("img",{attrs:{src:a("2a19"),alt:"logo",width:"50",height:"50"}})])}],d=a("5530"),p=a("2f62"),m={computed:Object(d["a"])({cart:function(){return this.$store.cart}},Object(p["c"])({authenticated:"auth/authenticated",user:"auth/user"})),methods:Object(d["a"])({},Object(p["b"])({logout:"auth/signout"}))},f=m,v=a("2877"),g=Object(v["a"])(f,u,l,!1,null,null,null),h=g.exports,C={title:"Channel Pizza",name:"App",components:{AppHeader:h}},b=C,_=Object(v["a"])(b,o,c,!1,null,null,null),x=_.exports,y=a("8c4f"),w=(a("7b17"),function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"carousel slide",attrs:{id:"carouselExampleSlidesOnly","data-ride":"carousel"}},[a("div",{staticClass:"carousel-inner"},[a("div",{staticClass:"carousel-item active",staticStyle:{Width:"60%,height:60%"}},[a("router-link",{attrs:{to:{name:"ProductList"}}},[a("img",{staticClass:"d-block w-100",attrs:{src:"https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg?cs=srgb&dl=pexels-brett-jordan-825661.jpg&fm=jpg",alt:"First slide"}})])],1),t._m(0)])])])}),O=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"carousel-caption d-none d-md-block"},[a("h5",[t._v("Best Pizza in London")]),a("p",[t._v(" Please click for the Menu")])])}],j={components:{}},k=j,P=(a("89f1"),Object(v["a"])(k,w,O,!1,null,null,null)),S=P.exports,$=(a("f9e3"),a("7ef0"),a("a66e")),E=a("554a"),R=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"card"},[r("div",{staticClass:"row"},[r("div",{staticClass:"col-md cart"},[r("div",{staticClass:"title"},[r("div",{staticClass:"row"},[t._m(0),r("div",{staticClass:"col-6 align-self-center text-right text-muted"}),r("div",{staticClass:"col-2 align-self-center text-right text-muted",attrs:{id:"hover"},on:{mouseover:function(e){t.hover=!0},click:function(e){return t.clear()}}},[t._v(" Clear Basket ")])])]),t._l(t.cart,(function(e){return r("div",{key:e.product.id,staticClass:"row border-top border-bottom"},[r("div",{staticClass:"row main align-items-center"},[r("div",{staticClass:"col-2"},[r("img",{staticClass:"img-fluid",attrs:{src:a("1771")("./"+e.product.image)}})]),r("div",{staticClass:"col-6"},[r("div",{staticClass:"row text-muted"},[t._v(t._s(e.product.title))]),r("div",{staticClass:"row"},[t._v(t._s(e.product.description))])]),r("div",{staticClass:"col",staticStyle:{"margin-left":"40px"}},[t._v(" "+t._s(e.quantity)+" ")]),r("div",{staticClass:"col"},[t._v(" $ "+t._s(e.product.price)+" "),r("span",{staticClass:"close"},[t._v("✕")])])])])}))],2)]),r("div",{staticClass:"col-md-4 summary"},[t._m(1),r("hr"),r("div",{staticClass:"row"},[r("div",{staticClass:"col",staticStyle:{"padding-left":"0"}},[t._v("Total Items ")]),r("div",{staticClass:"col text-right"},[t._v(t._s(t.cartItemCount))])]),r("div",{staticClass:"row",staticStyle:{"border-top":"1px solid rgba(0,0,0,.1)",padding:"2vh 0"}},[r("div",{staticClass:"col"},[t._v("TOTAL PRICE")]),r("div",{staticClass:"col text-right"},[t._v(" $ "+t._s(t.total))])]),t._v(" "),r("router-link",{attrs:{to:{name:"ProductList"}}},[r("button",{staticClass:"btn"},[t._v("CONTINUE SHOPPING")])]),t._v(" "),r("button",{staticClass:"btn",attrs:{id:"btcheckout"},on:{click:function(e){return t.checkOut()}}},[t._v("CHECKOUT")])],1)])},T=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"col-4"},[a("h4",[a("b",[t._v("Shopping Cart")])])])},function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("h5",[a("b",[t._v("Summary")])])])}],A=a("1da1"),I=(a("96cf"),a("ac1f"),a("5319"),{name:"Product Card",data:function(){return{hover:!1,order:{oderitems:[],quantity:[],total:null,userid:""}}},computed:Object(d["a"])({cart:function(){return this.$store.state.cart},cartItemCount:function(){return this.$store.getters.cartItemCount},total:function(){return this.$store.getters.total}},Object(p["d"])({userid:function(t){return t.auth.id},cart:function(t){return t.cart}})),methods:Object(d["a"])(Object(d["a"])({},Object(p["b"])({regOrder:"addOrder",clear:"cartClear"})),{},{redirect:function(){this.$router.replace({name:"Confirmation Page"})},showAlert:function(){var t={title:"Sign In Required",size:"sm"};this.$dialogs.alert("Please sign in or register to proceed to the checkout",t).then((function(t){console.log(t)}))},checkOut:function(){var t=this;return Object(A["a"])(regeneratorRuntime.mark((function e(){var a,r,n;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:for(a=[],r=[],n=0;n<t.cart.length;n++)a.push(t.cart[n].product.id),r.push(t.cart[n].quantity);if(t.order.orderitems=a,t.order.quantity=r,t.order.total=t.total,t.order.userid=t.userid,!t.userid){e.next=12;break}return e.next=10,t.regOrder(t.order).then((function(){t.redirect()})).catch((function(t){console.log(t.response.data.error)}));case 10:e.next=13;break;case 12:t.showAlert();case 13:case"end":return e.stop()}}),e)})))()}})}),q=I,D=(a("0c02"),Object(v["a"])(q,R,T,!1,null,"1307de47",null)),L=D.exports,U=function(){var t=this,e=t.$createElement,r=t._self._c||e;return t.product?r("div",{staticClass:"row mt-5"},[r("div",{staticClass:"col-4"},[r("img",{staticClass:"w-100",attrs:{src:a("1771")("./"+t.product.image)}})]),r("div",{staticClass:"col-8"},[r("h1",[t._v(" "+t._s(t.product.title))]),r("h3",[t._v(" $ "+t._s(t.product.price)+" ")]),r("input",{directives:[{name:"model",rawName:"v-model",value:t.quantity,expression:"quantity"}],staticClass:"text-center col-1 mr-2 p-1",attrs:{id:"#quantity_input",type:"text",value:"quantity"},domProps:{value:t.quantity},on:{input:function(e){e.target.composing||(t.quantity=e.target.value)}}}),r("button",{staticClass:"btn btn-primary",staticStyle:{"margin-left":"6px"},on:{click:t.addToCart}},[t._v(" Add to Cart ")]),r("p",{staticClass:"mt-4"},[t._v(" "+t._s(t.product.description)+" ")])])]):t._e()},z=[],N={data:function(){return{quantity:1}},props:["id"],mounted:function(){this.$store.dispatch("getProduct",this.id)},computed:{product:function(){return this.$store.state.product}},methods:{addToCart:function(){this.$store.dispatch("addProductToCart",{product:this.product,quantity:parseInt(this.quantity)})}}},M=N,H=Object(v["a"])(M,U,z,!1,null,null,null),B=H.exports,F=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("h1",[t._v(" Italian Pizza ")]),a("div",{staticClass:"d-flex align-items-stretch flex-wrap"},t._l(t.products,(function(e){return a("div",{key:e.id},["italian"===e.type?a("div",[a("ProductCard",{staticClass:"productcard",attrs:{id:"pr_i",product:e}})],1):t._e()])})),0),a("h1",[t._v(" Local Pizza ")]),a("div",{staticClass:"d-flex align-items-stretch flex-wrap"},t._l(t.products,(function(e){return a("div",{key:e.id},["local"===e.type?a("div",[a("ProductCard",{staticClass:"productcard",attrs:{id:"pr_l",product:e}})],1):t._e()])})),0),a("h1",[t._v(" Beverages")]),a("div",{staticClass:"d-flex align-items-stretch flex-wrap"},t._l(t.products,(function(e){return a("div",{key:e.id},["beverage"===e.type?a("div",[a("ProductCard",{staticClass:"productcard",attrs:{id:"pr_b",product:e}})],1):t._e()])})),0)])},G=[],Y=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"col-sm"},[r("div",{staticStyle:{"margin-left":"20px"}},[r("div",{staticClass:"card text-left",staticStyle:{width:"13rem"}},[r("img",{staticClass:"w-100 p-3",staticStyle:{height:"15vw"},attrs:{src:a("1771")("./"+t.product.image),alt:""}}),r("div",{staticClass:"card-body"},[r("h4",{staticClass:"card-title"},[r("router-link",{staticClass:"cartheader",attrs:{to:{name:"product",params:{id:t.product.id}}}},[t._v(" "+t._s(t.product.title)+" ")])],1),r("strong",[t._v(" $"+t._s(t.product.price)+" ")]),r("p",{staticClass:"card-text"},[t._v(" "+t._s(t.product.description))])]),r("div",{staticClass:"px-4 pb-3"},[r("button",{staticClass:"btn btn-secondary",on:{click:t.addToCart}},[t._v(" Add to Chart ")])])])])])},J=[],W={props:["product"],methods:{addToCart:function(){this.$store.dispatch("addProductToCart",{product:this.product,quantity:1})}}},K=W,Q=Object(v["a"])(K,Y,J,!1,null,null,null),V=Q.exports,X={components:{ProductCard:V},mounted:function(){this.$store.dispatch("getProducts")},computed:{products:function(){return this.$store.state.products}}},Z=X,tt=Object(v["a"])(Z,F,G,!1,null,null,null),et=tt.exports,at=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"card"},[r("div",{staticClass:"row"},[r("div",{staticClass:"col-md-8 cart"},[t._m(0),t._l(t.cart,(function(e){return r("div",{key:e.product.id,staticClass:"row border-top border-bottom"},[r("div",{staticClass:"row main align-items-center"},[r("div",{staticClass:"col-2"},[r("img",{staticClass:"img-fluid",attrs:{src:a("1771")("./"+e.product.image)}})]),r("div",{staticClass:"col"},[r("div",{staticClass:"row text-muted"},[t._v(t._s(e.product.title))])]),r("div",{staticClass:"col"},[t._v(" "+t._s(e.quantity))]),r("div",{staticClass:"col"},[t._v(" $ "+t._s(e.product.price)+" "),r("span",{staticClass:"close"},[t._v("✕")])])])])})),r("div",{staticClass:"row border-top border-bottom"},[r("div",{staticClass:"row main align-items-left"},[r("div",{staticClass:"col-2"},[t._v(" Total: ")]),r("div",{staticClass:"col"},[t._v(" $ "+t._s(t.total)+" ")])])])],2)])])},rt=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"title"},[a("div",{staticClass:"row"},[a("div",{staticClass:"col"},[a("h4",[a("b",[t._v("Order Confirmation")])])]),a("div",{staticClass:"col align-self-center text-right text-muted"})])])}],nt={name:"Order Confirmation",computed:{cart:function(){return this.$store.state.cart},total:function(){return this.$store.getters.total}}},st=nt,it=(a("48e4"),Object(v["a"])(st,at,rt,!1,null,"3e243ef1",null)),ot=it.exports,ct=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"container register-form"},[a("div",{staticClass:"form"},[t._m(0),a("form",{on:{submit:function(e){return e.preventDefault(),t.submit(e)}}},[a("div",{staticClass:"form-content"},[a("div",{staticClass:"row"},[a("div",{staticClass:"col-md-6"},[a("div",{staticClass:"form-group"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.form.username,expression:"form.username"}],staticClass:"form-control",attrs:{id:"username",type:"text",placeholder:"Your UserName *",value:""},domProps:{value:t.form.username},on:{input:function(e){e.target.composing||t.$set(t.form,"username",e.target.value)}}})])]),a("div",{staticClass:"col-md-6"},[a("div",{staticClass:"form-group"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.form.password,expression:"form.password"}],staticClass:"form-control",attrs:{id:"password",type:"text",placeholder:"Your Password *",value:""},domProps:{value:t.form.password},on:{input:function(e){e.target.composing||t.$set(t.form,"password",e.target.value)}}})])]),a("div",{staticClass:"row"},[a("div",{staticClass:"col-md-6"},[a("div",{staticClass:"form-group"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.firstname,expression:"firstname"}],staticClass:"form-control",attrs:{id:"firstname",type:"text",placeholder:"First Name *",value:""},domProps:{value:t.firstname},on:{input:function(e){e.target.composing||(t.firstname=e.target.value)}}})])]),a("div",{staticClass:"col-md-6"},[a("div",{staticClass:"form-group"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.lastname,expression:"lastname"}],staticClass:"form-control",attrs:{id:"lastname",type:"text",placeholder:"Last Name *",value:""},domProps:{value:t.lastname},on:{input:function(e){e.target.composing||(t.lastname=e.target.value)}}})])])]),a("div",{staticClass:"row"}),a("div",{staticClass:"note"},[t._v(" Adress Information ")]),a("div",{staticClass:"col-md-6"},[a("div",{staticClass:"form-group"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.code,expression:"code"}],staticClass:"form-control",attrs:{id:"code",autocomplete:"off",type:"text",placeholder:"Post Code *"},domProps:{value:t.code},on:{blur:t.postCodeSearch,input:function(e){e.target.composing||(t.code=e.target.value)}}})]),a("div",{staticClass:"form-group",staticStyle:{margin:"10% 25"}},[a("vue-bootstrap-typeahead",{attrs:{id:"country",placeholder:"Country",data:t.countryData},model:{value:t.country,callback:function(e){t.country=e},expression:"country"}})],1)]),a("div",{staticClass:"col-md-6"},[a("div",{staticStyle:{margin:"10% 25"}},[a("vue-bootstrap-typeahead",{attrs:{id:"region",data:t.regionData,placeholder:"Region"},model:{value:t.region,callback:function(e){t.region=e},expression:"region"}})],1),a("div",{staticClass:"form-group"},[a("input",{directives:[{name:"model",rawName:"v-model",value:t.adress_line,expression:"adress_line"}],staticClass:"form-control",attrs:{type:"text",id:"address_line",placeholder:"Adress Line 1",value:""},domProps:{value:t.adress_line},on:{input:function(e){e.target.composing||(t.adress_line=e.target.value)}}})])])]),a("div",{staticClass:"row"}),a("button",{staticClass:"btnSubmit",attrs:{type:"button"},on:{click:function(e){return t.userCheck()}}},[t._v("Submit")])])])])])},ut=[function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"note"},[a("p",[t._v("Registration Form")])])}],lt=a("bc3a"),dt=a.n(lt),pt={data:function(){return{code:"",region:"",country:"",postcodes:[],countryData:[],regionData:[],adress_line:"",firstname:"",lastname:"",form:{username:null,password:null,address:null,fullname:null}}},computed:Object(d["a"])({},Object(p["d"])({authorized:function(t){return t.auth.user}})),methods:Object(d["a"])(Object(d["a"])({postCodeSearch:function(){var t=this,e="https://api.postcodes.io/postcodes/"+this.code;dt.a.get(e).then((function(e){t.postcodes[0]=e.data.result,t.countryData.push(t.postcodes[0].country),t.regionData.push(t.postcodes[0].region)})).catch((function(t){console.log(t)}))}},Object(p["b"])({register:"auth/register"})),{},{showAlert:function(){var t={title:"Missing Fields",size:"sm"};this.$dialogs.alert("Please fulfill all fields",t)},showAlert2:function(){var t={title:"Username",size:"sm"};this.$dialogs.alert("Username Exists",t)},showSuccessAlert:function(){var t=this,e={title:"Success",size:"sm"};this.$dialogs.alert("You have successfully signed up",e).then((function(){t.$router.replace({name:"ProductList"})}))},userCheck:function(){var t=this;return Object(A["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:if(!(t.adress_line&&t.firstname&&t.form.username&&t.form.password&&t.lastname&&t.code&&t.country&&t.region)){e.next=5;break}return e.next=3,dt.a.get("http://localhost:8080/api/messages/findUserByUsername/"+t.form.username).then((function(e){e.data?t.showAlert2():t.submit()})).catch((function(t){console.log(t)}));case 3:e.next=6;break;case 5:t.showAlert();case 6:case"end":return e.stop()}}),e)})))()},submit:function(){var t=this;return Object(A["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return console.log("submit button"),t.form.address=t.code+" "+t.country+" "+t.region+" "+t.adress_line,t.form.fullname=t.firstname+" "+t.lastname,e.next=5,t.register(t.form).then((function(){t.showSuccessAlert()})).catch((function(t){console.log("catch"+t.message)}));case 5:case"end":return e.stop()}}),e)})))()}})},mt=pt,ft=Object(v["a"])(mt,ct,ut,!1,null,null,null),vt=ft.exports,gt={products:[],product:null,cart:[],order:[]},ht=function(t){return t.cart.reduce((function(t,e){return t+e.quantity}),0)},Ct=function(t){return t.cart.reduce((function(t,e){return Math.round(100*(t+e.product.price*e.quantity))/100}),0)},bt=function(t){return t.cart.products},_t=(a("7db0"),function(t,e){t.products=e}),xt=function(t,e){t.product=e},yt=function(t,e){var a=e.product,r=e.quantity,n=t.cart.find((function(t){return t.product.id===a.id}));n?n.quantity+=r:t.cart.push({product:a,quantity:r})},wt=function(t,e){t.order=e},Ot=function(t){t.cart=[]},jt=function(){var t=Object(A["a"])(regeneratorRuntime.mark((function t(e){var a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return a=e.commit,t.next=3,dt.a.get("http://localhost:8080/api/messages/findAllItems").then((function(t){a("SET_PRODUCTS",t.data)}));case 3:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}(),kt=function(){var t=Object(A["a"])(regeneratorRuntime.mark((function t(e,a){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return r=e.commit,t.next=3,dt.a.get("http://localhost:8080/api/messages/findItemById/"+a).then((function(t){r("SET_PRODUCT",t.data)}));case 3:case"end":return t.stop()}}),t)})));return function(e,a){return t.apply(this,arguments)}}(),Pt=function(t,e){var a=t.commit,r=e.product,n=e.quantity;a("ADD_TO_CART",{product:r,quantity:n})},St=function(){var t=Object(A["a"])(regeneratorRuntime.mark((function t(e,a){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return r=e.commit,t.next=3,dt.a.post("http://localhost:8080/api/messages/addOrder",a).then((function(t){r("SET_ORDER",t.data)})).catch((function(t){console.log(t)}));case 3:case"end":return t.stop()}}),t)})));return function(e,a){return t.apply(this,arguments)}}(),$t=function(t){var e=t.commit;e("CART_CLEAR")},Et={namespaced:!0,state:{id:null,user:null},getters:{authenticated:function(t){return t.id},user:function(t){return t.user}},mutations:{SET_ID:function(t,e){t.id=e},SET_USER:function(t,e){t.user=e},LOG_OUT:function(t){t.id=null,t.user=null}},actions:{signIn:function(t,e){return Object(A["a"])(regeneratorRuntime.mark((function a(){var r,n;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return r=t.commit,a.next=3,dt.a.post("http://localhost:8080/api/messages/user",e);case 3:n=a.sent,null!=n.data&&(r("SET_USER",n.data.username),r("SET_ID",n.data.id));case 5:case"end":return a.stop()}}),a)})))()},register:function(t,e){return Object(A["a"])(regeneratorRuntime.mark((function a(){var r,n;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return r=t.commit,a.next=3,dt.a.post("http://localhost:8080/api/messages/addUser",e);case 3:n=a.sent,null!=n.data&&(r("SET_USER",n.data.username),r("SET_ID",n.data.id));case 5:case"end":return a.stop()}}),a)})))()},signout:function(t){var e=t.commit;e("LOG_OUT")}}};i["a"].use(p["a"]);var Rt=new p["a"].Store({state:gt,getters:r,mutations:n,actions:s,modules:{auth:Et}}),Tt=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"container register-form"},[a("form",{on:{submit:function(e){return e.preventDefault(),t.submit(e)}}},[a("div",{staticClass:"form-group"},[a("label",{attrs:{for:"exampleInputEmail1"}},[t._v("Username")]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.form.username,expression:"form.username"}],staticClass:"form-control",attrs:{id:"username",type:"username","aria-describedby":"emailHelp",placeholder:"Enter Username"},domProps:{value:t.form.username},on:{input:function(e){e.target.composing||t.$set(t.form,"username",e.target.value)}}}),a("small",{staticClass:"form-text text-muted",attrs:{id:"emailHelp"}},[t._v("We'll never share your information with anyone else.")])]),a("div",{staticClass:"form-group"},[a("label",{attrs:{for:"exampleInputPassword1"}},[t._v("Password")]),a("input",{directives:[{name:"model",rawName:"v-model",value:t.form.password,expression:"form.password"}],staticClass:"form-control",attrs:{id:"password",type:"password",placeholder:"Password"},domProps:{value:t.form.password},on:{input:function(e){e.target.composing||t.$set(t.form,"password",e.target.value)}}})]),a("button",{staticClass:"btn btn-primary",attrs:{type:"submit",id:"submit"}},[t._v("Submit")])]),a("br"),t.loginfailed?a("div",[t._v(" Login failed : Login information is incorrect ")]):t._e()])},At=[],It={name:"signin",data:function(){return{form:{username:"",password:""},loginfailed:!1}},computed:Object(d["a"])({},Object(p["d"])({authorized:function(t){return t.auth.user}})),methods:Object(d["a"])(Object(d["a"])({},Object(p["b"])({signIn:"auth/signIn",authenticated:"auth/authenticated",user:"auth/authenticated"})),{},{redirect:function(){this.authorized?this.$router.replace({name:"ProductList"}):this.loginfailed=!0},submit:function(){var t=this;return Object(A["a"])(regeneratorRuntime.mark((function e(){return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,t.signIn(t.form).then((function(){t.redirect()}));case 2:case"end":return e.stop()}}),e)})))()}})},qt=It,Dt=Object(v["a"])(qt,Tt,At,!1,null,null,null),Lt=Dt.exports,Ut=a("2106"),zt=a.n(Ut),Nt=a("683f"),Mt=(a("62bb"),a("1aa0")),Ht=a.n(Mt),Bt=a("d45f");i["a"].use(Ht.a),i["a"].use(Nt["a"]),i["a"].component("vue-bootstrap-typeahead",Bt["a"]),i["a"].use(zt.a,dt.a),i["a"].use($["a"]),i["a"].use(E["a"]);var Ft=[{path:"/",component:S,name:"Home"},{path:"/minicart",component:L,name:"Minicart"},{path:"/product/:id",component:B,name:"product",props:!0},{path:"/productlist",component:et,name:"ProductList"},{path:"/login",component:Lt,name:"Login"},{path:"confirmation",component:ot,name:"Confirmation Page"},{path:"/register",component:vt,name:"Register"}],Gt=new y["a"]({routes:Ft,mode:"history"});i["a"].use(y["a"]),i["a"].config.productionTip=!1,new i["a"]({router:Gt,store:Rt,render:function(t){return t(x)}}).$mount("#app")},"7e2e":function(t,e,a){t.exports=a.p+"img/newyork.a4c71a73.jpg"},"7f84":function(t,e,a){},"89f1":function(t,e,a){"use strict";a("fca2")},aaef:function(t,e,a){t.exports=a.p+"img/turkish.d9cf3cd2.jpg"},abc7:function(t,e,a){t.exports=a.p+"img/deep-dish-pizza.83abe949.jpg"},cf05:function(t,e,a){t.exports=a.p+"img/logo.82b9c7a5.png"},d66a:function(t,e,a){},d6b6:function(t,e,a){t.exports=a.p+"img/still.55f3ef9c.jpg"},e05b:function(t,e,a){t.exports=a.p+"img/sicilian.fa5db564.jpg"},fca2:function(t,e,a){}});
//# sourceMappingURL=app.644a32b1.js.map
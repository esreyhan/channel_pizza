export const cartItemCount = (state) => {
    return state.cart.reduce((acc, item) =>  acc + item.quantity,0)
}

export const total = (state) => {
    return state.cart.reduce((acc, item) => Math.round((acc + item.product.price * item.quantity)*100) / 100, 0)
}
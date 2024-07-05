package com.example.childmealcardfinder.widget

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.childmealcardfinder.R
import com.example.childmealcardfinder.model.ShopItem

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopListViewHolder>() {

    private var shopList: List<ShopItem> = listOf()

    class ShopListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val shopNameTextView = itemView.findViewById<TextView>(R.id.shopName)
        private val shopTelTextView = itemView.findViewById<TextView>(R.id.shopTel)
        private val addressTextView = itemView.findViewById<TextView>(R.id.address)



        fun bind(shopItem: ShopItem) {
            shopNameTextView.text = shopItem.shopName   // 가맹점 이름
            shopTelTextView.text = shopItem.shopTel     // 가맹점 전화번호
            addressTextView.text = "${shopItem.sidoName} ${shopItem.gunguName}" +
                    " ${shopItem.shopRoadAddr} ${shopItem.shopRoadAddr2}"
            // 가맹점 주소 ("대구" + "구,군" + "주소1" + "주소2")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        Log.e("@@@onCreateViewHolder","@@@onCreateViewHolder")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_list_item, parent, false)
        return ShopListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        Log.e("@@@onBindViewHolder","@@@onBindViewHolder")

        holder.bind(shopList[position])
    }

    override fun getItemCount(): Int = shopList.size

    fun updateData(newShopList: List<ShopItem>) {
        shopList = newShopList
        notifyDataSetChanged()
    }


}

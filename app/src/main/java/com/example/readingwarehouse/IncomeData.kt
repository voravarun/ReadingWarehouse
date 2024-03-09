//package com.example.readingwarehouse
//
//import android.os.Parcel
//import android.os.Parcelable
//
//data class IncomeData (var bImage:Int, var bName:String,val bAuthor:String,var bVolume: Int, var bBarcode: Int): Parcelable {
//    constructor(parcel: Parcel) : this(
//        parcel.readInt(),
//        parcel.readString()!!,
//        parcel.readString()!!,
//        parcel.readInt(),
//        parcel.readInt(),
//    ) {
//
//    }
//    //
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeInt(bImage)
//        parcel.writeString(bName)
//        parcel.writeString(bAuthor)
//        parcel.writeInt(bVolume)
//        parcel.writeInt(bBarcode)
//    }
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<IncomeData> {
//        override fun createFromParcel(parcel: Parcel): IncomeData {
//            return IncomeData(parcel)
//        }
//
//        override fun newArray(size: Int): Array<IncomeData?> {
//            return arrayOfNulls(size)
//        }
//    }
//}
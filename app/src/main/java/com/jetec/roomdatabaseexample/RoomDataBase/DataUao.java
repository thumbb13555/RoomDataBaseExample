package com.jetec.roomdatabaseexample.RoomDataBase;

import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataUao {

    String tableName = "MyTable";
    /**=======================================================================================*/
    /**簡易新增所有資料的方法*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)//預設萬一執行出錯怎麼辦，REPLACE為覆蓋
    void insertData(MyData myData);

    /**複雜(?)新增所有資料的方法*/
    @Query("INSERT INTO "+tableName+"(name,phone,hobby,elseInfo) VALUES(:name,:phone,:hobby,:elseData)")
    void insertData(String name,String phone,String hobby,String elseData);

    /**=======================================================================================*/
    /**撈取全部資料*/
    @Query("SELECT * FROM " + tableName)
    List<MyData> displayAll();

    /**撈取某個名字的相關資料*/
    @Query("SELECT * FROM " + tableName +" WHERE name = :name")
    List<MyData> findDataByName(String name);

    /**=======================================================================================*/
    /**簡易更新資料的方法*/
    @Update
    void updateData(MyData myData);

    /**複雜(?)更新資料的方法*/
    @Query("UPDATE "+tableName+" SET name = :name,phone=:phone,hobby=:hobby,elseInfo = :elseInfo WHERE id = :id" )
    void updateData(int id,String name,String phone,String hobby,String elseInfo);

    /**=======================================================================================*/
    /**簡單刪除資料的方法*/
    @Delete
    void deleteData(MyData myData);

    /**複雜(?)刪除資料的方法*/
    @Query("DELETE  FROM " + tableName + " WHERE id = :id")
    void deleteData(int id);

}

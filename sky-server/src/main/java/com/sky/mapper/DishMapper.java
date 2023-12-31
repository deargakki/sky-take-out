package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {


   List<Dish> list(Dish dish);
   @AutoFill(value = OperationType.INSERT)
   public void insert(Dish dish);

   @Select("select count(id) from dish where category_id = #{categoryId}")
   Integer countByCategoryId(Long categoryId);


   Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

   Dish getById(Long id);

   void deleteByIds(List<Long> ids);

   @AutoFill(value = OperationType.UPDATE)
   void update(Dish dish);

   /**
    * 根据套餐id查询菜品
    * @param setmealId
    * @return
    */
   @Select("select a.* from dish a left join setmeal_dish b on a.id = b.dish_id where b.setmeal_id = #{setmealId}")
   List<Dish> getBySetmealId(Long setmealId);
}

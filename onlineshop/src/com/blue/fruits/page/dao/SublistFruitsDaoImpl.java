//package com.blue.fruits.page.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.hibernate.Query;
//import org.hibernate.SessionFactory;
//
//import com.blue.fruits.entity.Fruits;
//import com.blue.fruits.entity.Page;
//
//public class SublistFruitsDaoImpl {
//	@Resource
//	private SessionFactory sessionFactory;
//	//根据查询条件查询信息
////		public Page<Fruits> findFruits(Fruits searchModel,int PageNum,int pageSize){
////			List<Fruits> allFruitsList = getAllFruits(searchModel);
////			
////			Page<Fruits> page =  new Page<Fruits>(PageNum, pageSize,allFruitsList);
////			return page;
////		}
////		
//	//模仿获取所有数据
////		private List<Fruits> getAllFruits(Fruits searchModel){
////			List<Fruits> result = new ArrayList<Fruits>();
////			List<Object> paramList = new ArrayList<Object>();
////			
////			String fname = searchModel.getFruits_name();
////			int ftype = searchModel.getType_id();
////			StringBuilder sql = new StringBuilder("select * from Fruits where 1=1");
////			
////			if(fname!=null && !fname.equals("")) {
////				sql.append("and fruits_name like ?");
////		        paramList.add("%"+fname+"%");
////			}
////			if(ftype == 1||ftype==2||ftype==3) {
////				sql.append("and type_id = ?");
////		        paramList.add(ftype);
////			}
////			Query q=this.sessionFactory.getCurrentSession().createQuery("from Fruits");
////			result = q.list();
////			return result;
////		}
////		//JdbcUtil  jdbcUtil = null;
////		//try{
////		//jdbcUtil = new JdbcUtil();
////		//jdbcUtil.getConnection();
////		//List<Map<String,Object>> mapList = jdbcUtil.findResult(sql.toString(),paramList)
////        //}catch(SQLException e){
////		//    throw new RuntimeException("查询所有数据异常");
////		//}finally{
////		//    if(jdbcUtil!=null){
////		//        jdbcUtil.releaseConn();
////		//    }
////		//}
//}

package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RecipeProcess;
import model.dao.RecipeProcessDAO;

/**
 * 사용자 관리 API를 사용하는 개발자들이 직접 접근하게 되는 클래스.
 * UserDAO를 이용하여 데이터베이스에 데이터 조작 작업이 가능하도록 하며,
 * 데이터베이스의 데이터들을 이용하여 비지니스 로직을 수행하는 역할을 한다.
 * 비지니스 로직이 복잡한 경우에는 비지니스 로직만을 전담하는 클래스를 
 * 별도로 둘 수 있다.
 */
public class RecipeProcessManager {
	private static RecipeProcessManager recipeProcessManager = new RecipeProcessManager();
	private RecipeProcessDAO recipeProcessDAO;

	private RecipeProcessManager() {
		try {
			recipeProcessDAO = new RecipeProcessDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static RecipeProcessManager getInstance() {
		return recipeProcessManager;
	}
	
	public int create(RecipeProcess recipeProcess) throws SQLException{
		
		return recipeProcessDAO.create(recipeProcess);
	}

	public int update(RecipeProcess recipeProcess) throws SQLException{
		
		return recipeProcessDAO.update(recipeProcess);
	}	

	public int remove(String recipeId) throws SQLException{
		
		return recipeProcessDAO.remove(recipeId);
	}

	public ArrayList<RecipeProcess> findProcess(String recipeId)
		throws SQLException{
		ArrayList<RecipeProcess> process = recipeProcessDAO.findRecipeProcess(recipeId);
		return process;
	}

	public List<RecipeProcess> findRecipeProcessList() throws SQLException {
			return recipeProcessDAO.findRecipeProcessList();
	}
	
	
	public RecipeProcessDAO getRecipeProcessDAO() {
		return this.recipeProcessDAO;
	}
}

package service;

import dao.HomogeneousMineralDAO;
import entity.HomogeneousMineral;

import java.util.List;

public class HomogeneousMineralServiceImpl implements HomogeneousMineralService{
    private HomogeneousMineralDAO homogeneousMineralDAO;

    public void setHomogeneousMineralDAO(HomogeneousMineralDAO homogeneousMineralDAO) {
        this.homogeneousMineralDAO = homogeneousMineralDAO;
    }

    @Override
    public int insert(HomogeneousMineral homogeneousMineral) {
        return this.homogeneousMineralDAO.insert(homogeneousMineral);
    }

    @Override
    public List<HomogeneousMineral> selectAll() {
        return this.homogeneousMineralDAO.selectAll();
    }

    @Override
    public List<HomogeneousMineral> selectByCondition(HomogeneousMineral homogeneousMineral) {
        return this.homogeneousMineralDAO.selectByCondition(homogeneousMineral);
    }

    @Override
    public int delete(int id) {
        return this.homogeneousMineralDAO.delete(id);
    }

    @Override
    public int update(HomogeneousMineral homogeneousMineral) {
        return this.homogeneousMineralDAO.update(homogeneousMineral);
    }
}

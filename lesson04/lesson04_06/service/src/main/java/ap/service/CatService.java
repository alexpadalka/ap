package ap.service;

import ap.model.Cat;

public interface CatService {

  Cat get(String name);
  Cat get(Integer id);
  void saveOrUpdate(Cat cat);
  void delete(Cat cat);

}

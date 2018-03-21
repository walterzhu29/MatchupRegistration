package org.ez.springProj.MatchupRegistration.query;

import org.ez.springProj.MatchupRegistration.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserModelRepository extends CrudRepository<UserModel, String> {
}

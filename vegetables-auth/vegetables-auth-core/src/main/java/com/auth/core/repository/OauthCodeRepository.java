
package com.auth.core.repository;

import com.auth.base.BaseRepository;
import com.auth.core.entity.OauthCode;
import org.springframework.stereotype.Repository;


/**
 * @author automatic
 * @version 1.0
 * @data 2019-05-23 15:57
 **/

@Repository
public interface OauthCodeRepository extends BaseRepository<OauthCode, Long> {


}

package com.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.app.form.TeamEditForm;
import com.app.model.ContentMaster;
import com.app.model.FehCharacter;

@Repository
public interface FehCharacterRepository {

    void insertToMaster(FehCharacter acter);

    void insertToActer(FehCharacter acter);

    void updateFehCharacter(FehCharacter acter);

    List<FehCharacter> selectByDto(FehCharacter acter);

    List<FehCharacter> findSameActer(FehCharacter acter);

    FehCharacter selectOne(@Param("id")Integer id,@Param("imagePath")String imagePath);

    List<ContentMaster> selectByOrigin(String origin);

    int countByName(@Param("titleName") String titleName,@Param("baseName") String baseName);

    List<FehCharacter> selectByCustomize(@Param("whereQuery")String whereQuery);
    
    List<FehCharacter> selectByTeamNo(@Param("teamFlg")String teamFlg,@Param("imagePath")String imagePath);
    
    void saveTeam(@Param("teamNo") String teamNo,@Param("acterId") String acterId);
    
    List<String> selectAlertnativeImgId(TeamEditForm form);
    
    void initialTeam(@Param("teamNo") String teamNo);

}

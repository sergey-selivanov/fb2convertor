//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.01.13 at 12:49:43 AM EET 
//


package fb2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for genreType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="genreType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&gt;
 *     &lt;enumeration value="accounting"/&gt;
 *     &lt;enumeration value="adv_animal"/&gt;
 *     &lt;enumeration value="adv_geo"/&gt;
 *     &lt;enumeration value="adv_history"/&gt;
 *     &lt;enumeration value="adv_maritime"/&gt;
 *     &lt;enumeration value="adv_western"/&gt;
 *     &lt;enumeration value="adventure"/&gt;
 *     &lt;enumeration value="antique"/&gt;
 *     &lt;enumeration value="antique_ant"/&gt;
 *     &lt;enumeration value="antique_east"/&gt;
 *     &lt;enumeration value="antique_european"/&gt;
 *     &lt;enumeration value="antique_myths"/&gt;
 *     &lt;enumeration value="antique_russian"/&gt;
 *     &lt;enumeration value="aphorism_quote"/&gt;
 *     &lt;enumeration value="architecture_book"/&gt;
 *     &lt;enumeration value="auto_regulations"/&gt;
 *     &lt;enumeration value="banking"/&gt;
 *     &lt;enumeration value="child_adv"/&gt;
 *     &lt;enumeration value="child_det"/&gt;
 *     &lt;enumeration value="child_education"/&gt;
 *     &lt;enumeration value="child_prose"/&gt;
 *     &lt;enumeration value="child_sf"/&gt;
 *     &lt;enumeration value="child_tale"/&gt;
 *     &lt;enumeration value="child_verse"/&gt;
 *     &lt;enumeration value="children"/&gt;
 *     &lt;enumeration value="cinema_theatre"/&gt;
 *     &lt;enumeration value="city_fantasy"/&gt;
 *     &lt;enumeration value="comp_db"/&gt;
 *     &lt;enumeration value="comp_hard"/&gt;
 *     &lt;enumeration value="comp_osnet"/&gt;
 *     &lt;enumeration value="comp_programming"/&gt;
 *     &lt;enumeration value="comp_soft"/&gt;
 *     &lt;enumeration value="comp_www"/&gt;
 *     &lt;enumeration value="computers"/&gt;
 *     &lt;enumeration value="design"/&gt;
 *     &lt;enumeration value="det_action"/&gt;
 *     &lt;enumeration value="det_classic"/&gt;
 *     &lt;enumeration value="det_crime"/&gt;
 *     &lt;enumeration value="det_espionage"/&gt;
 *     &lt;enumeration value="det_hard"/&gt;
 *     &lt;enumeration value="det_history"/&gt;
 *     &lt;enumeration value="det_irony"/&gt;
 *     &lt;enumeration value="det_police"/&gt;
 *     &lt;enumeration value="det_political"/&gt;
 *     &lt;enumeration value="detective"/&gt;
 *     &lt;enumeration value="dragon_fantasy"/&gt;
 *     &lt;enumeration value="dramaturgy"/&gt;
 *     &lt;enumeration value="economics"/&gt;
 *     &lt;enumeration value="essays"/&gt;
 *     &lt;enumeration value="fantasy_fight"/&gt;
 *     &lt;enumeration value="foreign_action"/&gt;
 *     &lt;enumeration value="foreign_adventure"/&gt;
 *     &lt;enumeration value="foreign_antique"/&gt;
 *     &lt;enumeration value="foreign_business"/&gt;
 *     &lt;enumeration value="foreign_children"/&gt;
 *     &lt;enumeration value="foreign_comp"/&gt;
 *     &lt;enumeration value="foreign_contemporary"/&gt;
 *     &lt;enumeration value="foreign_contemporary_lit"/&gt;
 *     &lt;enumeration value="foreign_desc"/&gt;
 *     &lt;enumeration value="foreign_detective"/&gt;
 *     &lt;enumeration value="foreign_dramaturgy"/&gt;
 *     &lt;enumeration value="foreign_edu"/&gt;
 *     &lt;enumeration value="foreign_fantasy"/&gt;
 *     &lt;enumeration value="foreign_home"/&gt;
 *     &lt;enumeration value="foreign_humor"/&gt;
 *     &lt;enumeration value="foreign_language"/&gt;
 *     &lt;enumeration value="foreign_love"/&gt;
 *     &lt;enumeration value="foreign_novel"/&gt;
 *     &lt;enumeration value="foreign_other"/&gt;
 *     &lt;enumeration value="foreign_poetry"/&gt;
 *     &lt;enumeration value="foreign_prose"/&gt;
 *     &lt;enumeration value="foreign_psychology"/&gt;
 *     &lt;enumeration value="foreign_publicism"/&gt;
 *     &lt;enumeration value="foreign_religion"/&gt;
 *     &lt;enumeration value="foreign_sf"/&gt;
 *     &lt;enumeration value="geo_guides"/&gt;
 *     &lt;enumeration value="geography_book"/&gt;
 *     &lt;enumeration value="global_economy"/&gt;
 *     &lt;enumeration value="historical_fantasy"/&gt;
 *     &lt;enumeration value="home"/&gt;
 *     &lt;enumeration value="home_cooking"/&gt;
 *     &lt;enumeration value="home_crafts"/&gt;
 *     &lt;enumeration value="home_diy"/&gt;
 *     &lt;enumeration value="home_entertain"/&gt;
 *     &lt;enumeration value="home_garden"/&gt;
 *     &lt;enumeration value="home_health"/&gt;
 *     &lt;enumeration value="home_pets"/&gt;
 *     &lt;enumeration value="home_sex"/&gt;
 *     &lt;enumeration value="home_sport"/&gt;
 *     &lt;enumeration value="humor"/&gt;
 *     &lt;enumeration value="humor_anecdote"/&gt;
 *     &lt;enumeration value="humor_fantasy"/&gt;
 *     &lt;enumeration value="humor_prose"/&gt;
 *     &lt;enumeration value="humor_verse"/&gt;
 *     &lt;enumeration value="industries"/&gt;
 *     &lt;enumeration value="job_hunting"/&gt;
 *     &lt;enumeration value="literature_18"/&gt;
 *     &lt;enumeration value="literature_19"/&gt;
 *     &lt;enumeration value="literature_20"/&gt;
 *     &lt;enumeration value="love_contemporary"/&gt;
 *     &lt;enumeration value="love_detective"/&gt;
 *     &lt;enumeration value="love_erotica"/&gt;
 *     &lt;enumeration value="love_fantasy"/&gt;
 *     &lt;enumeration value="love_history"/&gt;
 *     &lt;enumeration value="love_sf"/&gt;
 *     &lt;enumeration value="love_short"/&gt;
 *     &lt;enumeration value="magician_book"/&gt;
 *     &lt;enumeration value="management"/&gt;
 *     &lt;enumeration value="marketing"/&gt;
 *     &lt;enumeration value="military_special"/&gt;
 *     &lt;enumeration value="music_dancing"/&gt;
 *     &lt;enumeration value="narrative"/&gt;
 *     &lt;enumeration value="newspapers"/&gt;
 *     &lt;enumeration value="nonf_biography"/&gt;
 *     &lt;enumeration value="nonf_criticism"/&gt;
 *     &lt;enumeration value="nonf_publicism"/&gt;
 *     &lt;enumeration value="nonfiction"/&gt;
 *     &lt;enumeration value="org_behavior"/&gt;
 *     &lt;enumeration value="paper_work"/&gt;
 *     &lt;enumeration value="pedagogy_book"/&gt;
 *     &lt;enumeration value="periodic"/&gt;
 *     &lt;enumeration value="personal_finance"/&gt;
 *     &lt;enumeration value="poetry"/&gt;
 *     &lt;enumeration value="popadanec"/&gt;
 *     &lt;enumeration value="popular_business"/&gt;
 *     &lt;enumeration value="prose_classic"/&gt;
 *     &lt;enumeration value="prose_counter"/&gt;
 *     &lt;enumeration value="prose_history"/&gt;
 *     &lt;enumeration value="prose_military"/&gt;
 *     &lt;enumeration value="prose_rus_classic"/&gt;
 *     &lt;enumeration value="prose_su_classics"/&gt;
 *     &lt;enumeration value="psy_alassic"/&gt;
 *     &lt;enumeration value="psy_childs"/&gt;
 *     &lt;enumeration value="psy_generic"/&gt;
 *     &lt;enumeration value="psy_personal"/&gt;
 *     &lt;enumeration value="psy_sex_and_family"/&gt;
 *     &lt;enumeration value="psy_social"/&gt;
 *     &lt;enumeration value="psy_theraphy"/&gt;
 *     &lt;enumeration value="real_estate"/&gt;
 *     &lt;enumeration value="ref_dict"/&gt;
 *     &lt;enumeration value="ref_encyc"/&gt;
 *     &lt;enumeration value="ref_guide"/&gt;
 *     &lt;enumeration value="ref_ref"/&gt;
 *     &lt;enumeration value="reference"/&gt;
 *     &lt;enumeration value="religion"/&gt;
 *     &lt;enumeration value="religion_esoterics"/&gt;
 *     &lt;enumeration value="religion_rel"/&gt;
 *     &lt;enumeration value="religion_self"/&gt;
 *     &lt;enumeration value="russian_contemporary"/&gt;
 *     &lt;enumeration value="russian_fantasy"/&gt;
 *     &lt;enumeration value="sci_biology"/&gt;
 *     &lt;enumeration value="sci_chem"/&gt;
 *     &lt;enumeration value="sci_culture"/&gt;
 *     &lt;enumeration value="sci_history"/&gt;
 *     &lt;enumeration value="sci_juris"/&gt;
 *     &lt;enumeration value="sci_linguistic"/&gt;
 *     &lt;enumeration value="sci_math"/&gt;
 *     &lt;enumeration value="sci_medicine"/&gt;
 *     &lt;enumeration value="sci_philosophy"/&gt;
 *     &lt;enumeration value="sci_phys"/&gt;
 *     &lt;enumeration value="sci_politics"/&gt;
 *     &lt;enumeration value="sci_religion"/&gt;
 *     &lt;enumeration value="sci_tech"/&gt;
 *     &lt;enumeration value="science"/&gt;
 *     &lt;enumeration value="sf"/&gt;
 *     &lt;enumeration value="sf_action"/&gt;
 *     &lt;enumeration value="sf_cyberpunk"/&gt;
 *     &lt;enumeration value="sf_detective"/&gt;
 *     &lt;enumeration value="sf_fantasy"/&gt;
 *     &lt;enumeration value="sf_heroic"/&gt;
 *     &lt;enumeration value="sf_history"/&gt;
 *     &lt;enumeration value="sf_horror"/&gt;
 *     &lt;enumeration value="sf_humor"/&gt;
 *     &lt;enumeration value="sf_social"/&gt;
 *     &lt;enumeration value="sf_space"/&gt;
 *     &lt;enumeration value="short_story"/&gt;
 *     &lt;enumeration value="sketch"/&gt;
 *     &lt;enumeration value="small_business"/&gt;
 *     &lt;enumeration value="sociology_book"/&gt;
 *     &lt;enumeration value="stock"/&gt;
 *     &lt;enumeration value="thriller"/&gt;
 *     &lt;enumeration value="upbringing_book"/&gt;
 *     &lt;enumeration value="vampire_book"/&gt;
 *     &lt;enumeration value="visual_arts"/&gt;
 *     &lt;enumeration value="unrecognised"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "genreType", namespace = "http://www.gribuser.ru/xml/fictionbook/2.0/genres")
@XmlEnum
public enum GenreType {

    @XmlEnumValue("accounting")
    ACCOUNTING("accounting"),
    @XmlEnumValue("adv_animal")
    ADV_ANIMAL("adv_animal"),
    @XmlEnumValue("adv_geo")
    ADV_GEO("adv_geo"),
    @XmlEnumValue("adv_history")
    ADV_HISTORY("adv_history"),
    @XmlEnumValue("adv_maritime")
    ADV_MARITIME("adv_maritime"),
    @XmlEnumValue("adv_western")
    ADV_WESTERN("adv_western"),
    @XmlEnumValue("adventure")
    ADVENTURE("adventure"),
    @XmlEnumValue("antique")
    ANTIQUE("antique"),
    @XmlEnumValue("antique_ant")
    ANTIQUE_ANT("antique_ant"),
    @XmlEnumValue("antique_east")
    ANTIQUE_EAST("antique_east"),
    @XmlEnumValue("antique_european")
    ANTIQUE_EUROPEAN("antique_european"),
    @XmlEnumValue("antique_myths")
    ANTIQUE_MYTHS("antique_myths"),
    @XmlEnumValue("antique_russian")
    ANTIQUE_RUSSIAN("antique_russian"),
    @XmlEnumValue("aphorism_quote")
    APHORISM_QUOTE("aphorism_quote"),
    @XmlEnumValue("architecture_book")
    ARCHITECTURE_BOOK("architecture_book"),
    @XmlEnumValue("auto_regulations")
    AUTO_REGULATIONS("auto_regulations"),
    @XmlEnumValue("banking")
    BANKING("banking"),
    @XmlEnumValue("child_adv")
    CHILD_ADV("child_adv"),
    @XmlEnumValue("child_det")
    CHILD_DET("child_det"),
    @XmlEnumValue("child_education")
    CHILD_EDUCATION("child_education"),
    @XmlEnumValue("child_prose")
    CHILD_PROSE("child_prose"),
    @XmlEnumValue("child_sf")
    CHILD_SF("child_sf"),
    @XmlEnumValue("child_tale")
    CHILD_TALE("child_tale"),
    @XmlEnumValue("child_verse")
    CHILD_VERSE("child_verse"),
    @XmlEnumValue("children")
    CHILDREN("children"),
    @XmlEnumValue("cinema_theatre")
    CINEMA_THEATRE("cinema_theatre"),
    @XmlEnumValue("city_fantasy")
    CITY_FANTASY("city_fantasy"),
    @XmlEnumValue("comp_db")
    COMP_DB("comp_db"),
    @XmlEnumValue("comp_hard")
    COMP_HARD("comp_hard"),
    @XmlEnumValue("comp_osnet")
    COMP_OSNET("comp_osnet"),
    @XmlEnumValue("comp_programming")
    COMP_PROGRAMMING("comp_programming"),
    @XmlEnumValue("comp_soft")
    COMP_SOFT("comp_soft"),
    @XmlEnumValue("comp_www")
    COMP_WWW("comp_www"),
    @XmlEnumValue("computers")
    COMPUTERS("computers"),
    @XmlEnumValue("design")
    DESIGN("design"),
    @XmlEnumValue("det_action")
    DET_ACTION("det_action"),
    @XmlEnumValue("det_classic")
    DET_CLASSIC("det_classic"),
    @XmlEnumValue("det_crime")
    DET_CRIME("det_crime"),
    @XmlEnumValue("det_espionage")
    DET_ESPIONAGE("det_espionage"),
    @XmlEnumValue("det_hard")
    DET_HARD("det_hard"),
    @XmlEnumValue("det_history")
    DET_HISTORY("det_history"),
    @XmlEnumValue("det_irony")
    DET_IRONY("det_irony"),
    @XmlEnumValue("det_police")
    DET_POLICE("det_police"),
    @XmlEnumValue("det_political")
    DET_POLITICAL("det_political"),
    @XmlEnumValue("detective")
    DETECTIVE("detective"),
    @XmlEnumValue("dragon_fantasy")
    DRAGON_FANTASY("dragon_fantasy"),
    @XmlEnumValue("dramaturgy")
    DRAMATURGY("dramaturgy"),
    @XmlEnumValue("economics")
    ECONOMICS("economics"),
    @XmlEnumValue("essays")
    ESSAYS("essays"),
    @XmlEnumValue("fantasy_fight")
    FANTASY_FIGHT("fantasy_fight"),
    @XmlEnumValue("foreign_action")
    FOREIGN_ACTION("foreign_action"),
    @XmlEnumValue("foreign_adventure")
    FOREIGN_ADVENTURE("foreign_adventure"),
    @XmlEnumValue("foreign_antique")
    FOREIGN_ANTIQUE("foreign_antique"),
    @XmlEnumValue("foreign_business")
    FOREIGN_BUSINESS("foreign_business"),
    @XmlEnumValue("foreign_children")
    FOREIGN_CHILDREN("foreign_children"),
    @XmlEnumValue("foreign_comp")
    FOREIGN_COMP("foreign_comp"),
    @XmlEnumValue("foreign_contemporary")
    FOREIGN_CONTEMPORARY("foreign_contemporary"),
    @XmlEnumValue("foreign_contemporary_lit")
    FOREIGN_CONTEMPORARY_LIT("foreign_contemporary_lit"),
    @XmlEnumValue("foreign_desc")
    FOREIGN_DESC("foreign_desc"),
    @XmlEnumValue("foreign_detective")
    FOREIGN_DETECTIVE("foreign_detective"),
    @XmlEnumValue("foreign_dramaturgy")
    FOREIGN_DRAMATURGY("foreign_dramaturgy"),
    @XmlEnumValue("foreign_edu")
    FOREIGN_EDU("foreign_edu"),
    @XmlEnumValue("foreign_fantasy")
    FOREIGN_FANTASY("foreign_fantasy"),
    @XmlEnumValue("foreign_home")
    FOREIGN_HOME("foreign_home"),
    @XmlEnumValue("foreign_humor")
    FOREIGN_HUMOR("foreign_humor"),
    @XmlEnumValue("foreign_language")
    FOREIGN_LANGUAGE("foreign_language"),
    @XmlEnumValue("foreign_love")
    FOREIGN_LOVE("foreign_love"),
    @XmlEnumValue("foreign_novel")
    FOREIGN_NOVEL("foreign_novel"),
    @XmlEnumValue("foreign_other")
    FOREIGN_OTHER("foreign_other"),
    @XmlEnumValue("foreign_poetry")
    FOREIGN_POETRY("foreign_poetry"),
    @XmlEnumValue("foreign_prose")
    FOREIGN_PROSE("foreign_prose"),
    @XmlEnumValue("foreign_psychology")
    FOREIGN_PSYCHOLOGY("foreign_psychology"),
    @XmlEnumValue("foreign_publicism")
    FOREIGN_PUBLICISM("foreign_publicism"),
    @XmlEnumValue("foreign_religion")
    FOREIGN_RELIGION("foreign_religion"),
    @XmlEnumValue("foreign_sf")
    FOREIGN_SF("foreign_sf"),
    @XmlEnumValue("geo_guides")
    GEO_GUIDES("geo_guides"),
    @XmlEnumValue("geography_book")
    GEOGRAPHY_BOOK("geography_book"),
    @XmlEnumValue("global_economy")
    GLOBAL_ECONOMY("global_economy"),
    @XmlEnumValue("historical_fantasy")
    HISTORICAL_FANTASY("historical_fantasy"),
    @XmlEnumValue("home")
    HOME("home"),
    @XmlEnumValue("home_cooking")
    HOME_COOKING("home_cooking"),
    @XmlEnumValue("home_crafts")
    HOME_CRAFTS("home_crafts"),
    @XmlEnumValue("home_diy")
    HOME_DIY("home_diy"),
    @XmlEnumValue("home_entertain")
    HOME_ENTERTAIN("home_entertain"),
    @XmlEnumValue("home_garden")
    HOME_GARDEN("home_garden"),
    @XmlEnumValue("home_health")
    HOME_HEALTH("home_health"),
    @XmlEnumValue("home_pets")
    HOME_PETS("home_pets"),
    @XmlEnumValue("home_sex")
    HOME_SEX("home_sex"),
    @XmlEnumValue("home_sport")
    HOME_SPORT("home_sport"),
    @XmlEnumValue("humor")
    HUMOR("humor"),
    @XmlEnumValue("humor_anecdote")
    HUMOR_ANECDOTE("humor_anecdote"),
    @XmlEnumValue("humor_fantasy")
    HUMOR_FANTASY("humor_fantasy"),
    @XmlEnumValue("humor_prose")
    HUMOR_PROSE("humor_prose"),
    @XmlEnumValue("humor_verse")
    HUMOR_VERSE("humor_verse"),
    @XmlEnumValue("industries")
    INDUSTRIES("industries"),
    @XmlEnumValue("job_hunting")
    JOB_HUNTING("job_hunting"),
    @XmlEnumValue("literature_18")
    LITERATURE_18("literature_18"),
    @XmlEnumValue("literature_19")
    LITERATURE_19("literature_19"),
    @XmlEnumValue("literature_20")
    LITERATURE_20("literature_20"),
    @XmlEnumValue("love_contemporary")
    LOVE_CONTEMPORARY("love_contemporary"),
    @XmlEnumValue("love_detective")
    LOVE_DETECTIVE("love_detective"),
    @XmlEnumValue("love_erotica")
    LOVE_EROTICA("love_erotica"),
    @XmlEnumValue("love_fantasy")
    LOVE_FANTASY("love_fantasy"),
    @XmlEnumValue("love_history")
    LOVE_HISTORY("love_history"),
    @XmlEnumValue("love_sf")
    LOVE_SF("love_sf"),
    @XmlEnumValue("love_short")
    LOVE_SHORT("love_short"),
    @XmlEnumValue("magician_book")
    MAGICIAN_BOOK("magician_book"),
    @XmlEnumValue("management")
    MANAGEMENT("management"),
    @XmlEnumValue("marketing")
    MARKETING("marketing"),
    @XmlEnumValue("military_special")
    MILITARY_SPECIAL("military_special"),
    @XmlEnumValue("music_dancing")
    MUSIC_DANCING("music_dancing"),
    @XmlEnumValue("narrative")
    NARRATIVE("narrative"),
    @XmlEnumValue("newspapers")
    NEWSPAPERS("newspapers"),
    @XmlEnumValue("nonf_biography")
    NONF_BIOGRAPHY("nonf_biography"),
    @XmlEnumValue("nonf_criticism")
    NONF_CRITICISM("nonf_criticism"),
    @XmlEnumValue("nonf_publicism")
    NONF_PUBLICISM("nonf_publicism"),
    @XmlEnumValue("nonfiction")
    NONFICTION("nonfiction"),
    @XmlEnumValue("org_behavior")
    ORG_BEHAVIOR("org_behavior"),
    @XmlEnumValue("paper_work")
    PAPER_WORK("paper_work"),
    @XmlEnumValue("pedagogy_book")
    PEDAGOGY_BOOK("pedagogy_book"),
    @XmlEnumValue("periodic")
    PERIODIC("periodic"),
    @XmlEnumValue("personal_finance")
    PERSONAL_FINANCE("personal_finance"),
    @XmlEnumValue("poetry")
    POETRY("poetry"),
    @XmlEnumValue("popadanec")
    POPADANEC("popadanec"),
    @XmlEnumValue("popular_business")
    POPULAR_BUSINESS("popular_business"),
    @XmlEnumValue("prose_classic")
    PROSE_CLASSIC("prose_classic"),
    @XmlEnumValue("prose_counter")
    PROSE_COUNTER("prose_counter"),
    @XmlEnumValue("prose_history")
    PROSE_HISTORY("prose_history"),
    @XmlEnumValue("prose_military")
    PROSE_MILITARY("prose_military"),
    @XmlEnumValue("prose_rus_classic")
    PROSE_RUS_CLASSIC("prose_rus_classic"),
    @XmlEnumValue("prose_su_classics")
    PROSE_SU_CLASSICS("prose_su_classics"),
    @XmlEnumValue("psy_alassic")
    PSY_ALASSIC("psy_alassic"),
    @XmlEnumValue("psy_childs")
    PSY_CHILDS("psy_childs"),
    @XmlEnumValue("psy_generic")
    PSY_GENERIC("psy_generic"),
    @XmlEnumValue("psy_personal")
    PSY_PERSONAL("psy_personal"),
    @XmlEnumValue("psy_sex_and_family")
    PSY_SEX_AND_FAMILY("psy_sex_and_family"),
    @XmlEnumValue("psy_social")
    PSY_SOCIAL("psy_social"),
    @XmlEnumValue("psy_theraphy")
    PSY_THERAPHY("psy_theraphy"),
    @XmlEnumValue("real_estate")
    REAL_ESTATE("real_estate"),
    @XmlEnumValue("ref_dict")
    REF_DICT("ref_dict"),
    @XmlEnumValue("ref_encyc")
    REF_ENCYC("ref_encyc"),
    @XmlEnumValue("ref_guide")
    REF_GUIDE("ref_guide"),
    @XmlEnumValue("ref_ref")
    REF_REF("ref_ref"),
    @XmlEnumValue("reference")
    REFERENCE("reference"),
    @XmlEnumValue("religion")
    RELIGION("religion"),
    @XmlEnumValue("religion_esoterics")
    RELIGION_ESOTERICS("religion_esoterics"),
    @XmlEnumValue("religion_rel")
    RELIGION_REL("religion_rel"),
    @XmlEnumValue("religion_self")
    RELIGION_SELF("religion_self"),
    @XmlEnumValue("russian_contemporary")
    RUSSIAN_CONTEMPORARY("russian_contemporary"),
    @XmlEnumValue("russian_fantasy")
    RUSSIAN_FANTASY("russian_fantasy"),
    @XmlEnumValue("sci_biology")
    SCI_BIOLOGY("sci_biology"),
    @XmlEnumValue("sci_chem")
    SCI_CHEM("sci_chem"),
    @XmlEnumValue("sci_culture")
    SCI_CULTURE("sci_culture"),
    @XmlEnumValue("sci_history")
    SCI_HISTORY("sci_history"),
    @XmlEnumValue("sci_juris")
    SCI_JURIS("sci_juris"),
    @XmlEnumValue("sci_linguistic")
    SCI_LINGUISTIC("sci_linguistic"),
    @XmlEnumValue("sci_math")
    SCI_MATH("sci_math"),
    @XmlEnumValue("sci_medicine")
    SCI_MEDICINE("sci_medicine"),
    @XmlEnumValue("sci_philosophy")
    SCI_PHILOSOPHY("sci_philosophy"),
    @XmlEnumValue("sci_phys")
    SCI_PHYS("sci_phys"),
    @XmlEnumValue("sci_politics")
    SCI_POLITICS("sci_politics"),
    @XmlEnumValue("sci_religion")
    SCI_RELIGION("sci_religion"),
    @XmlEnumValue("sci_tech")
    SCI_TECH("sci_tech"),
    @XmlEnumValue("science")
    SCIENCE("science"),
    @XmlEnumValue("sf")
    SF("sf"),
    @XmlEnumValue("sf_action")
    SF_ACTION("sf_action"),
    @XmlEnumValue("sf_cyberpunk")
    SF_CYBERPUNK("sf_cyberpunk"),
    @XmlEnumValue("sf_detective")
    SF_DETECTIVE("sf_detective"),
    @XmlEnumValue("sf_fantasy")
    SF_FANTASY("sf_fantasy"),
    @XmlEnumValue("sf_heroic")
    SF_HEROIC("sf_heroic"),
    @XmlEnumValue("sf_history")
    SF_HISTORY("sf_history"),
    @XmlEnumValue("sf_horror")
    SF_HORROR("sf_horror"),
    @XmlEnumValue("sf_humor")
    SF_HUMOR("sf_humor"),
    @XmlEnumValue("sf_social")
    SF_SOCIAL("sf_social"),
    @XmlEnumValue("sf_space")
    SF_SPACE("sf_space"),
    @XmlEnumValue("short_story")
    SHORT_STORY("short_story"),
    @XmlEnumValue("sketch")
    SKETCH("sketch"),
    @XmlEnumValue("small_business")
    SMALL_BUSINESS("small_business"),
    @XmlEnumValue("sociology_book")
    SOCIOLOGY_BOOK("sociology_book"),
    @XmlEnumValue("stock")
    STOCK("stock"),
    @XmlEnumValue("thriller")
    THRILLER("thriller"),
    @XmlEnumValue("upbringing_book")
    UPBRINGING_BOOK("upbringing_book"),
    @XmlEnumValue("vampire_book")
    VAMPIRE_BOOK("vampire_book"),
    @XmlEnumValue("visual_arts")
    VISUAL_ARTS("visual_arts"),
    @XmlEnumValue("unrecognised")
    UNRECOGNISED("unrecognised");
    private final String value;

    GenreType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GenreType fromValue(String v) {
        for (GenreType c: GenreType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

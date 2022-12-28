package com.sm.graduation.root.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.graduation.accident.pojo.AccidentRecord;
import com.sm.graduation.accident.service.AccidentRecordService;
import com.sm.graduation.admin.pojo.AdminInfo;
import com.sm.graduation.admin.service.AdminInfoService;
import com.sm.graduation.checkin.pojo.CheckIn;
import com.sm.graduation.checkin.service.CheckInService;
import com.sm.graduation.common.loginpojo.LoginPojo;
import com.sm.graduation.common.result.AjaxResult;
import com.sm.graduation.dormitory.pojo.DormitoryAllocation;
import com.sm.graduation.dormitory.service.DormitoryAllocationService;
import com.sm.graduation.food.pojo.MonthlyCatering;
import com.sm.graduation.food.service.MonthlyCateringService;
import com.sm.graduation.health.pojo.HealthRecords;
import com.sm.graduation.health.service.HealthRecordsService;
import com.sm.graduation.high.pojo.HighRisk;
import com.sm.graduation.high.service.HighRiskService;
import com.sm.graduation.medication.pojo.Medication;
import com.sm.graduation.medication.service.MedicationService;
import com.sm.graduation.nurse.pojo.Nursing;
import com.sm.graduation.nurse.service.NursingService;
import com.sm.graduation.older.pojo.OlderInfo;
import com.sm.graduation.older.service.OlderInfoService;
import com.sm.graduation.out.pojo.GoOut;
import com.sm.graduation.out.service.GoOutService;
import com.sm.graduation.usr.pojo.UsrInfo;
import com.sm.graduation.usr.service.UsrInfoService;
import com.sm.graduation.visitor.pojo.Visitor;
import com.sm.graduation.visitor.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sm.graduation.root.pojo.RootInfo;
import com.sm.graduation.root.service.RootInfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sm.graduation.common.result.AjaxResult.*;

@SuppressWarnings("all")
@RestController
@RequestMapping("/root")
public class RootInfoController {

    @Autowired
    private RootInfoService rootInfoService;

    @Autowired
    private AdminInfoService adminInfoService;

    @Autowired
    private UsrInfoService usrInfoService;

    @Autowired
    private HealthRecordsService healthRecordsService;

    @Autowired
    private HighRiskService highRiskService;

    @Autowired
    private MedicationService medicationService;

    @Autowired
    private MonthlyCateringService monthlyCateringService;

    @Autowired
    private GoOutService goOutService;

    @Autowired
    private OlderInfoService olderInfoService;

    @Autowired
    private DormitoryAllocationService dormitoryAllocationService;

    @Autowired
    private AccidentRecordService accidentRecordService;

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private CheckInService checkInService;

    @Autowired
    private NursingService nursingService;

    private String olderName;



    private boolean login;
    /** 登录验证 */
    @RequestMapping("/loginIn")
    public AjaxResult loginIn(HttpServletRequest request, HttpSession session, String username,
                              LoginPojo loginPojo, RootInfo rootInfo,AdminInfo adminInfo, UsrInfo usrInfo){


        if (loginPojo.getCaptcha().equalsIgnoreCase(String.valueOf(request.getSession().getAttribute("captCode")))) {
            //超管登录
            if (0 == loginPojo.getPower()){
                rootInfo.setName(loginPojo.getUsername());
                rootInfo.setPwd(loginPojo.getPassword());
                RootInfo root = rootInfoService.sltName(rootInfo);
                if (root == null){
                    return AjaxResult.error("登录名不存在");
                }
                login = rootInfoService.loginIn(rootInfo);
                if (login) {
                    session.setAttribute("username",root.getNickName());
                    session.setAttribute("power",root.getPower());
                    session.setAttribute("root",root);
                    return AjaxResult.success(0,"登录成功");
                } else return AjaxResult.error("登录名或密码错误");
            }

            //管理员登录
            if (1 == loginPojo.getPower()){
                adminInfo.setAdminLogin(loginPojo.getUsername());
                adminInfo.setAdminPwd(loginPojo.getPassword());
                AdminInfo admin = adminInfoService.sltName(adminInfo);
                if (admin == null){
                    return AjaxResult.error("登录名不存在");
                }
                login = adminInfoService.loginIn(adminInfo);
                if (login) {
                    session.setAttribute("username",admin.getAdminName());
                    session.setAttribute("power",admin.getPower());
                    session.setAttribute("admin",admin);
                    return AjaxResult.success(1,"登录成功");
                } else return AjaxResult.error("登录名或密码错误");
            }

            //用户登录
            if (2 == loginPojo.getPower()){
                usrInfo.setUsrLogin(loginPojo.getUsername());
                usrInfo.setUsrPwd(loginPojo.getPassword());
                UsrInfo usr = usrInfoService.sltName(usrInfo);
                if (usr == null){
                    return AjaxResult.error("登录名不存在");
                }
                login = usrInfoService.loginIn(usrInfo);
                if (login) {
                    String olderName = usr.getOlderName();
                    HealthRecords older = healthRecordsService.older_dorm(olderName);
                    this.olderName = older.getName();
                    session.setAttribute("username",usr.getUsrName());
                    session.setAttribute("power",usr.getUsrPwd());
                    session.setAttribute("usr",usr);
                    session.setAttribute("older",older);
                    return AjaxResult.success(2,"登录成功");
                } else return AjaxResult.error("登录名或密码错误");
            }

        }
            return AjaxResult.error("验证码错误");

    }


    /** admin  ---  List */
    @RequestMapping("/adminList")
    public AjaxResult adminList(@RequestParam(defaultValue = "1" , value = "page") Integer pageNum,
                                @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                                @RequestParam(defaultValue = ""  , value = "adminName") String user
                                ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (user == null || user.equals("")) {
            map.put("user","");
            List<AdminInfo> admins = adminInfoService.listAll(map);
            PageInfo<AdminInfo> page = new PageInfo<>(admins);
            return successData(page.getTotal(), admins);
        }
            map.put("user",user);
            List<AdminInfo> admins = adminInfoService.listAll(map);
            PageInfo<AdminInfo> page = new PageInfo<>(admins);
            return successData(page.getTotal(), admins);
    }


    /** usr --- List */
    @RequestMapping("/userList")
    public AjaxResult userList(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                               @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                               @RequestParam(defaultValue = "" , value = "usrName") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<UsrInfo> usrInfos = usrInfoService.listAll(map);
            PageInfo<UsrInfo> page = new PageInfo<>(usrInfos);
            return successData(page.getTotal(), usrInfos);
        }
        map.put("usr",usr);
        List<UsrInfo> usrInfos = usrInfoService.listAll(map);
        PageInfo<UsrInfo> page = new PageInfo<>(usrInfos);
        return successData(page.getTotal(), usrInfos);
    }


    /** 健康档案 */
    @RequestMapping("/healthRisk")
    public AjaxResult healthRisk(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                                 @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                                 @RequestParam(defaultValue = "" , value = "olderName") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<HealthRecords> healthRecords = healthRecordsService.listAll(map);
            PageInfo<HealthRecords> page = new PageInfo<>(healthRecords);
            return successData(page.getTotal(), healthRecords);
        }
        map.put("usr",usr);
        List<HealthRecords> healthRecords = healthRecordsService.listAll(map);
        PageInfo<HealthRecords> page = new PageInfo<>(healthRecords);
        return successData(page.getTotal(), healthRecords);
    }


    /** 高危存档 */
    @RequestMapping("/highRisk")
    public AjaxResult highRisk(@RequestParam(defaultValue = "1",  value = "page") Integer pageNum,
                               @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                               @RequestParam(defaultValue = ""  , value = "olderName") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<HighRisk> highRisks = highRiskService.listAll(map);
            PageInfo<HighRisk> page = new PageInfo<>(highRisks);
            return successData(page.getTotal(), highRisks);
        }
        map.put("usr",usr);
        List<HighRisk> highRisks = highRiskService.listAll(map);
        PageInfo<HighRisk> page = new PageInfo<>(highRisks);
        return successData(page.getTotal(), highRisks);
    }


    /** 药品管理 */
    @RequestMapping("/medication")
    public AjaxResult medication(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                                 @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                                 @RequestParam(defaultValue = "" , value = "medication") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<Medication> medications = medicationService.listAll(map);
            PageInfo<Medication> page = new PageInfo<>(medications);
            return successData(page.getTotal(), medications);
        }
        map.put("usr",usr);
        List<Medication> medications = medicationService.listAll(map);
        PageInfo<Medication> page = new PageInfo<>(medications);
        return successData(page.getTotal(), medications);
    }


    /** 每月餐饮 */
    @RequestMapping("/catering")
    public AjaxResult catering(@RequestParam(defaultValue = "1",  value = "page") Integer pageNum,
                               @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                               @RequestParam(defaultValue = ""  , value = "monTime") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<MonthlyCatering> monthlyCaterings = monthlyCateringService.listAll(map);
            PageInfo<MonthlyCatering> page = new PageInfo<>(monthlyCaterings);
            return successData(page.getTotal(), monthlyCaterings);
        }
        map.put("usr",usr);
        List<MonthlyCatering> monthlyCaterings = monthlyCateringService.listAll(map);
        PageInfo<MonthlyCatering> page = new PageInfo<>(monthlyCaterings);
        return successData(page.getTotal(), monthlyCaterings);
    }


    /** 外出报备 */
    @RequestMapping("/goOut")
    public AjaxResult goOut(@RequestParam(defaultValue = "1",  value = "page") Integer pageNum,
                            @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                            @RequestParam(defaultValue = ""  , value = "olderName") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<GoOut> goOuts = goOutService.listAll(map);
            PageInfo<GoOut> page = new PageInfo<>(goOuts);
            return successData(page.getTotal(), goOuts);
        }
        map.put("usr",usr);
        List<GoOut> goOuts = goOutService.listAll(map);
        PageInfo<GoOut> page = new PageInfo<>(goOuts);
        return successData(page.getTotal(), goOuts);
    }

    @RequestMapping("/goOutUsr")
    public AjaxResult goOutUsr(@RequestParam(defaultValue = "1",  value = "page") Integer pageNum,
                            @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                            @RequestParam(defaultValue = ""  , value = "olderName") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("olderName",olderName);
            List<GoOut> goOuts = goOutService.go_listAll(map);
            PageInfo<GoOut> page = new PageInfo<>(goOuts);
            return successData(page.getTotal(), goOuts);
        }
        map.put("usr",usr);
        List<GoOut> goOuts = goOutService.listAll(map);
        PageInfo<GoOut> page = new PageInfo<>(goOuts);
        return successData(page.getTotal(), goOuts);
    }


    /** 入住登记 */
    @RequestMapping("/register")
    public AjaxResult register(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                               @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                               @RequestParam(defaultValue = ""  , value = "olderName") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<OlderInfo> olderInfos = olderInfoService.listAll(map);
            PageInfo<OlderInfo> page = new PageInfo<>(olderInfos);
            return successData(page.getTotal(), olderInfos);
        }
        map.put("usr",usr);
        List<OlderInfo> olderInfos = olderInfoService.listAll(map);
        PageInfo<OlderInfo> page = new PageInfo<>(olderInfos);
        return successData(page.getTotal(), olderInfos);
    }


    /** 寝室分配 */
    @RequestMapping("/dormitory")
    public AjaxResult dormitory(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                                @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                                @RequestParam(defaultValue = ""  , value = "dormitory") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<DormitoryAllocation> dormitoryAllocations = dormitoryAllocationService.listAll(map);
            PageInfo<DormitoryAllocation> page = new PageInfo<>(dormitoryAllocations);
            return successData(page.getTotal(), dormitoryAllocations);
        }
        map.put("usr",usr);
        List<DormitoryAllocation> dormitoryAllocations = dormitoryAllocationService.listAll(map);
        PageInfo<DormitoryAllocation> page = new PageInfo<>(dormitoryAllocations);
        return successData(page.getTotal(), dormitoryAllocations);
    }

    /** 事故记录 */
    @RequestMapping("/accident")
    public AjaxResult accident(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                               @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                               @RequestParam(defaultValue = ""  , value = "accTime") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<AccidentRecord> accidentRecords = accidentRecordService.listAll(map);
            PageInfo<AccidentRecord> page = new PageInfo<>(accidentRecords);
            return successData(page.getTotal(), accidentRecords);
        }
        map.put("usr",usr);
        List<AccidentRecord> accidentRecords = accidentRecordService.listAll(map);
        PageInfo<AccidentRecord> page = new PageInfo<>(accidentRecords);
        return successData(page.getTotal(), accidentRecords);
    }

    /** 访客记录 */
    @RequestMapping("/visitor")
    public AjaxResult visitor(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                              @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                              @RequestParam(defaultValue = ""  , value = "name") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<Visitor> visitors = visitorService.listAll(map);
            PageInfo<Visitor> page = new PageInfo<>(visitors);
            return successData(page.getTotal(), visitors);
        }
        map.put("usr",usr);
        List<Visitor> visitors = visitorService.listAll(map);
        PageInfo<Visitor> page = new PageInfo<>(visitors);
        return successData(page.getTotal(), visitors);
    }
    /** 入住费用 */
    @RequestMapping("/checkIn")
    public AjaxResult checkIn(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                              @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                              @RequestParam(defaultValue = ""  , value = "year") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<CheckIn> checkIns = checkInService.listAll(map);
            PageInfo<CheckIn> page = new PageInfo<>(checkIns);
            return successData(page.getTotal(), checkIns);
        }
        map.put("usr",usr);
        List<CheckIn> checkIns = checkInService.listAll(map);
        PageInfo<CheckIn> page = new PageInfo<>(checkIns);
        return successData(page.getTotal(), checkIns);
    }
    /** 护理费用 */
    @RequestMapping("/nursing")
    public AjaxResult nursing(@RequestParam(defaultValue = "1", value = "page") Integer pageNum,
                              @RequestParam(defaultValue = "10", value = "limit") Integer pageSize,
                              @RequestParam(defaultValue = ""  , value = "nurseRank") String usr
    ){
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        if (usr == null || usr.equals("")) {
            map.put("usr","");
            List<Nursing> nursings = nursingService.listAll(map);
            PageInfo<Nursing> page = new PageInfo<>(nursings);
            return successData(page.getTotal(), nursings);
        }
        map.put("usr",usr);
        List<Nursing> nursings = nursingService.listAll(map);
        PageInfo<Nursing> page = new PageInfo<>(nursings);
        return successData(page.getTotal(), nursings);
    }



    //==============添加功能=================

    /** 添加管理员 */
    @RequestMapping("/addAdmin")
    public AjaxResult addAmin(AdminInfo adminInfo){
        int insert = adminInfoService.insert(adminInfo);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }

    /** 添加用户 */
    @RequestMapping("/addUsr")
    public AjaxResult addUsr(UsrInfo usrInfo){
        UsrInfo results = usrInfoService.sltName(usrInfo);
        if (results != null){
            return error("添加失败,登录名已被注册");
        }
        int insert = usrInfoService.insert(usrInfo);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }


    @RequestMapping("/addHealth")
    public AjaxResult addHealth(HealthRecords healthRecords){
        System.out.println(healthRecords);
        int insert = healthRecordsService.insert(healthRecords);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }

    @RequestMapping("/addHigh")
    public AjaxResult addHigh(HighRisk highRisk){
        System.out.println(highRisk);
        int insert = highRiskService.insert(highRisk);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }

    @RequestMapping("/addMedication")
    public AjaxResult addMedication(Medication medication){
        System.out.println(medication);
        int insert = medicationService.insert(medication);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }


    @RequestMapping("/addMon")
    public AjaxResult addMon(MonthlyCatering monthlyCatering){
        System.out.println(monthlyCatering);
        int insert = monthlyCateringService.insert(monthlyCatering);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }


    @RequestMapping("/addOut")
    public AjaxResult addOut(GoOut goOut){
        System.out.println(goOut);
        int insert = goOutService.insert(goOut);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }


    @RequestMapping("/addOlder")
    public AjaxResult addOlder(OlderInfo olderInfo){
        System.out.println(olderInfo);
        int insert = olderInfoService.insert(olderInfo);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }


    @RequestMapping("/addDorm")
    public AjaxResult addDorm(DormitoryAllocation dormitoryAllocation){
        System.out.println(dormitoryAllocation);
        int insert = dormitoryAllocationService.insert(dormitoryAllocation);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }

    @RequestMapping("/addAcc")
    public AjaxResult addAcc(AccidentRecord accidentRecord){
        System.out.println(accidentRecord);
        int insert = accidentRecordService.insert(accidentRecord);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }

    @RequestMapping("/addVis")
    public AjaxResult addVis(Visitor visitor){
        System.out.println(visitor);
        int insert = visitorService.insert(visitor);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }

    @RequestMapping("/addCheck")
    public AjaxResult addCheck(CheckIn checkIn){
        System.out.println(checkIn);
        int insert = checkInService.insert(checkIn);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }

    @RequestMapping("/addNurs")
    public AjaxResult addNurs(Nursing nursing){
        System.out.println(nursing);
        int insert = nursingService.insert(nursing);
        if (1 == insert){
            return success("添加成功");
        }
        return error("添加失败");
    }




    //==============修改功能=================

    /** 修改管理员 */
    @RequestMapping("/modifyAdmin")
    public AjaxResult modifyAmin(AdminInfo adminInfo){
        int update = adminInfoService.update(adminInfo);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyUsr")
    public AjaxResult modifyUsr(UsrInfo usrInfo){
        int update = usrInfoService.update(usrInfo);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyHealth")
    public AjaxResult modifyHealth(HealthRecords healthRecords){
        System.out.println(healthRecords);
        int update = healthRecordsService.update(healthRecords);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }


    @RequestMapping("/modifyHigh")
    public AjaxResult modifyHigh(HighRisk highRisk){
        System.out.println(highRisk);
        int update = highRiskService.update(highRisk);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }


    @RequestMapping("/modifyMedication")
    public AjaxResult modifyMedication(Medication medication){
        System.out.println(medication);
        int update = medicationService.update(medication);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyMon")
    public AjaxResult modifyMon(MonthlyCatering monthlyCatering){
        System.out.println(monthlyCatering);
        int update = monthlyCateringService.update(monthlyCatering);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyOut")
    public AjaxResult modifyOut(GoOut goOut){
        System.out.println(goOut);
        int update = goOutService.update(goOut);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyOlder")
    public AjaxResult modifyOlder(OlderInfo olderInfo){
        int update = olderInfoService.update(olderInfo);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyDorm")
    public AjaxResult modifyDorm(DormitoryAllocation dormitoryAllocation){
        int update = dormitoryAllocationService.update(dormitoryAllocation);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyAcc")
    public AjaxResult modifyAcc(AccidentRecord accidentRecord){
        int update = accidentRecordService.update(accidentRecord);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyVis")
    public AjaxResult modifyVis(Visitor visitor){
        int update = visitorService.update(visitor);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyCheck")
    public AjaxResult modifyCheck(CheckIn checkIn){
        int update = checkInService.update(checkIn);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }

    @RequestMapping("/modifyNurs")
    public AjaxResult modifyNurs(Nursing nursing){
        int update = nursingService.update(nursing);
        if (1 == update){
            return success("修改成功");
        }
        return error("修改失败");
    }




    //==============删除功能=================


    /** 删除管理员 */
    @RequestMapping("/delAdmin")
    public AjaxResult delAdmin(Integer adminId){
        adminInfoService.delAdmin(adminId);
        return success("删除成功");
    }
    /** 批量删除管理员 */
    @RequestMapping("/batchDelAdmin")
    public AjaxResult batchDel(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    adminInfoService.delAdmin(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }

    /** 删除用户 */
    @RequestMapping("/delUsr")
    public AjaxResult delUsr(Integer usrId){
        usrInfoService.delete(usrId);
        return success("删除成功");
    }
    /** 批量删除用户 */
    @RequestMapping("/batchDelUsr")
    public AjaxResult batchDelUsr(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    usrInfoService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }


    @RequestMapping("/delHealth")
    public AjaxResult delHealth(Integer id){
        healthRecordsService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelHealth")
    public AjaxResult batchDelHealth(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    healthRecordsService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }

    @RequestMapping("/delHigh")
    public AjaxResult delHigh(Integer id){
        highRiskService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelHigh")
    public AjaxResult batchDelHigh(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    highRiskService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }

    @RequestMapping("/delMedication")
    public AjaxResult delMedication(Integer id){
        medicationService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelMedication")
    public AjaxResult batchDelMedication(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    medicationService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }


    @RequestMapping("/delMon")
    public AjaxResult delMon(Integer id){
        monthlyCateringService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelMon")
    public AjaxResult batchDelMon(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    monthlyCateringService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }

    @RequestMapping("/delOut")
    public AjaxResult delOut(Integer id){
        goOutService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelOut")
    public AjaxResult batchDelOut(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    goOutService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }


    @RequestMapping("/delOlder")
    public AjaxResult delOlder(@RequestParam(value = "olderId") Integer id){
        olderInfoService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelOlder")
    public AjaxResult batchDelOlder(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    olderInfoService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }

    @RequestMapping("/delDorm")
    public AjaxResult delDorm(@RequestParam(value = "id") Integer id){
        dormitoryAllocationService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelDorm")
    public AjaxResult batchDelDorm(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    dormitoryAllocationService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }


    @RequestMapping("/delAcc")
    public AjaxResult delAcc(@RequestParam(value = "id") Integer id){
        accidentRecordService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelAcc")
    public AjaxResult batchDelAcc(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    accidentRecordService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }


    @RequestMapping("/delVis")
    public AjaxResult delVis(@RequestParam(value = "id") Integer id){
        visitorService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelVis")
    public AjaxResult batchDelVis(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    visitorService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }

    @RequestMapping("/delCheck")
    public AjaxResult delCheck(@RequestParam(value = "id") Integer id){
        checkInService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelCheck")
    public AjaxResult batchDelCheck(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    checkInService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }

    @RequestMapping("/delNurs")
    public AjaxResult delNurs(@RequestParam(value = "id") Integer id){
        nursingService.delete(id);
        return success("删除成功");
    }

    @RequestMapping("/batchDelNurs")
    public AjaxResult batchDelNurs(String listStr){
        if (null != listStr && !"".equals(listStr)){
            String[] ids = listStr.split(",");
            for (String id:ids) {
                if (null != id && !"".equals(id)) {
                    System.out.println(id);
                    nursingService.delete(Integer.valueOf(id));
                }
            }
        }
        return success("删除成功");
    }




    /** root 修改密码 */
    @RequestMapping("/altPwd")
    public AjaxResult altPwd(String pwd,String rpwd) {
        if(!pwd.equals(rpwd)) return error( "两次密码不一致");

        if (pwd != null && !pwd.equals("")) {
            int i = rootInfoService.altPwd(pwd);
            if (i != 0) {
                return success(0, "修改成功");
            }
        }
        return error("密码不允许为空");
    }

    @RequestMapping("/adminAltPwd")
    public AjaxResult adminAltPwd(String pwd,String rpwd,Map map,HttpServletRequest request) {
        if(!pwd.equals(rpwd)) return error( "两次密码不一致");

        if (pwd != null && !pwd.equals("")) {
            AdminInfo admin= (AdminInfo) request.getSession().getAttribute("admin");
            Long id = admin.getAdminId();
            map.put("pwd",pwd);
            map.put("id",id);
            int i = adminInfoService.altPwd(map);
            if (i != 0) {
                return success(0, "修改成功");
            }
        }
        return error("密码不允许为空");
    }

    @RequestMapping("/usrAltPwd")
    public AjaxResult usrAltPwd(String pwd,String rpwd,Map map,HttpServletRequest request) {
        if(!pwd.equals(rpwd)) return error( "两次密码不一致");

        if (pwd != null && !pwd.equals("")) {
            UsrInfo usr = (UsrInfo) request.getSession().getAttribute("usr");
            Long id = usr.getUsrId();
            map.put("pwd",pwd);
            map.put("id",id);
            int i = usrInfoService.altPwd(map);
            if (i != 0) {
                return success(0, "修改成功");
            }
        }
        return error("密码不允许为空");
    }
}

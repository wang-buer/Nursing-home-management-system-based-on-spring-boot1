package com.sm.graduation.view;


import com.sm.graduation.accident.pojo.AccidentRecord;
import com.sm.graduation.accident.service.AccidentRecordService;
import com.sm.graduation.admin.pojo.AdminInfo;
import com.sm.graduation.admin.service.AdminInfoService;
import com.sm.graduation.checkin.pojo.CheckIn;
import com.sm.graduation.checkin.service.CheckInService;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/** 试图跳转 */

@Controller
@RequestMapping("/view")
public class ViewController {

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


    /** 首页跳转 **/
    @GetMapping("/welcome")
    public String welcome() {
        return "page/welcome";
    }

    @GetMapping("/welcome1")
    public String welcome1() {
        return "page/welcome1";
    }

    /** admin --- list */
    @GetMapping("/adminList")
    public String adminList() {
        return "page/adminList";
    }

    /** user --- list */
    @GetMapping("/usrList")
    public String userList(){
        return "page/usrList";
    }

    /** 健康档案 */
    @GetMapping("/healthRisk")
    public String healthRisk(){
        return "page/healthRisk";
    }

    /** 高危存档 */
    @GetMapping("/highRisk")
    public String heightRisk(){
        return "page/highRisk";
    }

    /** 药品管理 */
    @GetMapping("/medication")
    public String medication(){
        return "page/medication";
    }

    /** 每月餐饮 */
    @GetMapping("/catering")
    public String catering(){
        return "page/catering";
    }

    /** 外出报备 */
    @GetMapping("/goOut")
    public String goOut(){
        return "page/goOut";
    }

    @GetMapping("/goOutUsr")
    public String goOutUsr(){
        return "page/goOut-usr";
    }

    /** 入住登记 */
    @GetMapping("/register")
    public String register(){
        return "page/register";
    }

    /** 寝室分配 */
    @GetMapping("/dormitory")
    public String dormitory(){
        return "page/dormitory";
    }

    /** 事故记录 */
    @GetMapping("/accident")
    public String accident(){
        return "page/accident";
    }

    /** 访客 */
    @GetMapping("/visitor")
    public String visitor(){
        return "page/visitor";
    }

    /** 入住登记 */
    @GetMapping("/checkIn")
    public String checkIn(){
        return "page/checkIn";
    }

    /** 护理 */
    @GetMapping("/nursing")
    public String nursing(){
        return "page/nursing";
    }



    //===============跳转模块： 添加功能===================


    /** 添 加 管 理 员 */
    @GetMapping("/addAdmin")
    public String addAdmin(){
        return "page/add/addAdmin";
    }

    /** 添 加 用 户 */
    @GetMapping("/addUsr")
    public String addUsr(){
        return "page/add/addUsr";
    }

    /** 添 加 健 康 档 案 */
    @GetMapping("/addHealth")
    public String addHealth(){
        return "page/add/addHealth";
    }

    /** 添 加 高 危 档 案 */
    @GetMapping("/addHigh")
    public String addHigh(){
        return "page/add/addHigh";
    }

    /** 添 加 药 品 */
    @GetMapping("/addMedication")
    public String addMedication(){
        return "page/add/addMedication";
    }

    /** 添 加 餐 饮 信 息 */
    @GetMapping("/addMon")
    public String addCatering(){
        return "page/add/addCatering";
    }

    /** 添 加 外 出 报 备 */
    @GetMapping("/addOut")
    public String addGoOut(){
        return "page/add/addOut";
    }

    @GetMapping("/addOlder")
    public String addOlder(){
        return "page/add/addOlder";
    }

    /** 添 加 寝 室 */
    @GetMapping("/addDorm")
    public String addDormitory(){
        return "page/add/addDormitory";
    }

    /** 添 加 事 故 记 录 */
    @GetMapping("/addAcc")
    public String addAccident(){
        return "page/add/addAccident";
    }

    /** 添 加 访 客 */
    @GetMapping("/addVis")
    public String addVisitor(){
        return "page/add/addVisitor";
    }

    @GetMapping("/addCheck")
    public String addCheck(){
        return "page/add/addCheckIn";
    }

    @GetMapping("/addNurs")
    public String addVis(){
        return "page/add/addNursing";
    }





    //================编辑功能==================

    /** 修 改 管 理 员 */
    @GetMapping("/modifyAdmin")
    public String modifyAdmin(@RequestParam(value = "adminId") long adminId,
                              Model model){
        AdminInfo adminInfo = adminInfoService.getById(adminId);
        model.addAttribute("adminInfo",adminInfo);
        return "page/modify/modifyAdmin";
    }

    @GetMapping("/modifyUsr")
    public String modifyUsr(@RequestParam(value = "usrId") long usrId,
                              Model model){
        UsrInfo usrInfo = usrInfoService.getById(usrId);
        model.addAttribute("usrInfo",usrInfo);
        return "page/modify/modifyUsr";
    }

    @GetMapping("/modifyHealth")
    public String modifyHealth(@RequestParam(value = "id") long id,
                            Model model){
        HealthRecords healthRecord = healthRecordsService.getById(id);
        model.addAttribute("healthRecord",healthRecord);
        return "page/modify/modifyHealth";
    }


    @GetMapping("/modifyHigh")
    public String modifyHigh(@RequestParam(value = "id") long id,
                               Model model){
        HighRisk highRisk = highRiskService.getById(id);
        model.addAttribute("highRisk",highRisk);
        return "page/modify/modifyHigh";
    }

    @GetMapping("/modifyMedication")
    public String modifyMedication(@RequestParam(value = "id") long id,
                             Model model){
        Medication medication = medicationService.getById(id);
        model.addAttribute("medication",medication);
        return "page/modify/modifyMedication";
    }


    @GetMapping("/modifyMon")
    public String modifyMon(@RequestParam(value = "id") long id,
                             Model model){
        MonthlyCatering monthlyCatering = monthlyCateringService.getById(id);
        model.addAttribute("monthlyCatering",monthlyCatering);
        return "page/modify/modifyCatering";
    }


    @GetMapping("/modifyOut")
    public String modifyOut(@RequestParam(value = "id") long id,
                            Model model){
        GoOut goOut = goOutService.getById(id);
        model.addAttribute("goOut",goOut);
        return "page/modify/modifyOut";
    }

    @GetMapping("/modifyOlder")
    public String modifyOlder(@RequestParam(value = "olderId") long olderId,
                              Model model){
        OlderInfo olderInfo = olderInfoService.getById(olderId);
        model.addAttribute("olderInfo",olderInfo);
        return "page/modify/modifyOlder";
    }



    @GetMapping("/modifyDorm")
    public String modifyDorm(@RequestParam(value = "id") long id,
                              Model model){
        DormitoryAllocation dormitoryAllocation = dormitoryAllocationService.getById(id);
        model.addAttribute("dormitoryAllocation",dormitoryAllocation);
        return "page/modify/modifyDormitory";
    }


    @GetMapping("/modifyAcc")
    public String modifyAcc(@RequestParam(value = "id") long id,
                             Model model){
        AccidentRecord accidentRecord = accidentRecordService.getById(id);
        model.addAttribute("accidentRecord",accidentRecord);
        return "page/modify/modifyAccident";
    }


    @GetMapping("/modifyVis")
    public String modifyVis(@RequestParam(value = "id") long id,
                             Model model){
        Visitor visitor = visitorService.getById(id);
        model.addAttribute("visitor",visitor);
        return "page/modify/modifyVisitor";
    }


    @GetMapping("/modifyCheck")
    public String modifyCheck(@RequestParam(value = "id") long id,
                             Model model){
        CheckIn checkIn = checkInService.getById(id);
        model.addAttribute("checkIn",checkIn);
        return "page/modify/modifyCheckIn";
    }


    @GetMapping("/modifyNurs")
    public String modifyNurs(@RequestParam(value = "id") long id,
                             Model model){
        Nursing nursing = nursingService.getById(id);
        model.addAttribute("nursing",nursing);
        return "page/modify/modifyNursing";
    }




    @GetMapping("/rootInfo")
    public String info() {
        return "page/rootInfo";
    }

    @GetMapping("/admin")
    public String admin() {
        return "page/admin";
    }

    @GetMapping("/usr")
    public String usr() {
        return "page/usr";
    }

    @GetMapping("/older")
    public String older() {
        return "page/older";
    }


    @GetMapping("/rootAltPwd")
    public String rootAltPwd() {
        return "page/modify/rootAltPwd";
    }

    @GetMapping("/adminAltPwd")
    public String adminAltPwd() {
        return "page/modify/adminAltPwd";
    }

    @GetMapping("/usrAltPwd")
    public String usrAltPwd() {
        return "page/modify/usrAltPwd";
    }





}

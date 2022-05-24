package com.ilabquality.tests;

import java.io.File;
import java.io.IOException;

import com.ilabquality.modules.testing.BaseTest;
import org.apache.poi.EncryptedDocumentException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ilabquality.dataprovider.JsonDataProvider;
import com.ilabquality.pages.AdminCenterPage;
import com.ilabquality.pages.EmployeeProfilePage;
import com.ilabquality.pages.LoginPage;
import com.ilabquality.pages.RehireFormPage;
import com.ilabquality.pages.RehireInactiveEmployeePage;
import com.ilabquality.pages.TerminationPage;

public class Rehire extends BaseTest {

	private JsonDataProvider global;
	private JsonDataProvider rehire;
	private String url;
	private String username;
	private String password;
	private String eventReason;
	private String eventReasonFinal;
	private String phone;
	private String position;
	private String payGroup;
	private String employee;
	private String hireDate;
	private String employeeClass;
	private String terminationDate;
	private String terminationReason;
	private String terminationComment;
	private String businessUnit;
	private String location;
	private String jobClassification;
	private String jobTitle;
	private String timeZone;
	private String addressType;

	private LoginPage loginPage;
	private AdminCenterPage homePage;
	private RehireInactiveEmployeePage rehireFirstPage;
	private RehireFormPage rehireFormPage;
	private EmployeeProfilePage employeePage;
	private TerminationPage terminationPage;

	private JsonDataProvider rehireAddress;
	private JsonDataProvider rehireCompensationInformation;
	private JsonDataProvider rehireIdentity;
	private JsonDataProvider rehireJobInformation;

	@Before
	public void setUp() throws EncryptedDocumentException, IOException {
		global = new JsonDataProvider(
				System.getProperty("user.dir") + File.separator + "resources" + File.separator + "global.json");
		rehire = new JsonDataProvider(
				System.getProperty("user.dir") + File.separator + "data" + File.separator + "rehire.json");
		/*
		 * rehireAddress= new JsonDataProvider( System.getProperty("user.dir") +
		 * File.separator + "dataTest" + File.separator + "RehireAddress.json");
		 * rehireCompensationInformation = new JsonDataProvider(
		 * System.getProperty("user.dir") + File.separator + "dataTest" + File.separator
		 * + "Rehire(1)CompensationInformation.json"); rehireIdentity = new
		 * JsonDataProvider( System.getProperty("user.dir") + File.separator +
		 * "dataTest" + File.separator + "RehireIdentity.json"); rehireJobInformation =
		 * new JsonDataProvider( System.getProperty("user.dir") + File.separator +
		 * "dataTest" + File.separator + "RehireJobInformation.json");
		 */

/*		loginPage = new LoginPage(fw);
		homePage = new AdminCenterPage(fw);
		rehireFirstPage = new RehireInactiveEmployeePage(fw);
		rehireFormPage = new RehireFormPage(fw);
		employeePage = new EmployeeProfilePage(fw);
		terminationPage = new TerminationPage(fw);*/
	}

	@Test
	public void test() throws Exception {

		try {
			url = global.getValue("Global.urlSystem");
			username = global.getValue("Global.login");
			password = global.getValue("Global.password");

			eventReason = rehire.getValue("Rehire.eventReason");
			eventReasonFinal = rehire.getValue("Rehire.eventReasonFinal");
			phone = rehire.getValue("Rehire.phone");
			position = rehire.getValue("Rehire.position");
			//employeeClass = rehire.getValue("Rehire.employeeClass");
			payGroup = rehire.getValue("Rehire.payGroup");
			employee = rehire.getValue("Rehire.employee");
			hireDate = rehire.getValue("Rehire.hireDate");
			timeZone = rehire.getValue("Rehire.timezone");
			addressType = rehire.getValue("Rehire.addressType");

			terminationDate = rehire.getValue("Rehire.terminationDate");
			terminationReason = rehire.getValue("Rehire.terminationReason");
			terminationComment = rehire.getValue("Rehire.terminationComment");

			System.out.println(eventReason);
			System.out.println(phone);
			System.out.println(position);
			System.out.println(payGroup);
			System.out.println(employee);
			System.out.println(hireDate);
			//System.out.println(businessUnit);
			//System.out.println(location);
			//System.out.println(jobClassification);
			//System.out.println(jobTitle);
			System.out.println(addressType);

		} catch (Exception e) {
			System.out.println("Failed to get data");
			throw e;
		}

		try {
			loginPage.navigateTo(url);
			Thread.sleep(5000);
			loginPage.setUsername(username);
			loginPage.setPassword(password);
			loginPage.clickLogin();
		} catch (Exception e) {
			System.out.println("Failed to login");
			throw e;
		}

		try {
/*			Thread.sleep(8000);
			fw.clickElement("//*[@id=\"bizXSearchField-I\"]");
			homePage.setSearch(eventReason);
			fw.timeout(5000);
			homePage.sendKeyEnterInSearch();
			homePage.sendKeyDownInSearch();
			homePage.sendKeyEnterInSearch();*/
		} catch (Exception e) {
			System.out.println("Failed to search");
			throw e;
		}

		try {
			Thread.sleep(7000);
//			rehireFirstPage.clickRehireEmployee();
			rehireFirstPage.sendEmployeeName(employee);
			rehireFirstPage.clickGo();
			Thread.sleep(5000);
			rehireFirstPage.clickRehireEmployee();
		} catch (Exception e) {
			System.out.println("Failed to select Employee");
			throw e;
		}

		try {
			rehireFormPage.sendHireDate(hireDate);
			rehireFormPage.selectEventReason(eventReason);
			Thread.sleep(2000);
			rehireFormPage.clickContinueFirst();
			rehireFormPage.waitUntilLoadingDisappear();
	//		rehireFormPage.inputCountryCode(countryCode);
	//		rehireFormPage.inputAreaCode(areaCode);
			Thread.sleep(8000);

			rehireFormPage.selectAddressType(addressType);
			//rehireFormPage.clickContinueSecond();


			//rehireFormPage.selectAddressType(addressType);
			//Thread.sleep(3000);
			//rehireFormPage.inputPhone(phone);
			Thread.sleep(4000);
			rehireFormPage.clickContinueSecond();
			rehireFormPage.waitUntilLoadingDisappear();
			Thread.sleep(5000);
			rehireFormPage.selectPosition(position);
			//rehireFormPage.selectEmployeeClass(employeeClass);
			rehireFormPage.waitUntilLoadingDisappear();
			/*
			 rehireFormPage.selectLocation(location);
			rehireFormPage.selectTimezone(timeZone);
			rehireFormPage.enterJobTitle(jobTitle);
			rehireFormPage.selectJobClassification(jobClassification);
			 */

			// Thread.sleep(8000);
			// rehireFormPage.selectPayScaleType(payScaleType);
			// Thread.sleep(5000);
			// rehireFormPage.selectPayScaleArea(payScaleArea);
			Thread.sleep(5000);
			rehireFormPage.clickButtonContinueThird();
			Thread.sleep(5000);
			rehireFormPage.waitUntilLoadingDisappear();
      Thread.sleep(5000);
			rehireFormPage.selectPayGroup(payGroup);
			//fw.clickElement("//*[@id=\"__mbox-btn-0-BDI-content\"]");
			Thread.sleep(5000);
			// rehireFormPage.clickButtonAddCompensation();
			// rehireFormPage.selectCompensationPayComponent(compensationPayComponent);
			// rehireFormPage.inputCompensationAmount(compensationAmount);
			// rehireFormPage.selectCompensationCurrency(compensationCurrency);
			// rehireFormPage.selectCompensationFrequency(compensationFrequecy);
			// Thread.sleep(5000);
			// rehireFormPage.waitUntilLoadingDisappear();
			rehireFormPage.clickButtonContinueForth();
			rehireFormPage.waitUntilLoadingDisappear();

		} catch (Exception e) {
			System.out.println("Failed to fill form");
			throw e;
		}

		try {
			Thread.sleep(7000);
			rehireFormPage.clickViewProfile();
			//Thread.sleep(8000);
			employeePage.clickEmploymentLabel();
			Thread.sleep(2000);
			employeePage.clickJobInformationHistory();
			Thread.sleep(5000);
			/*
			changeHistoryPage.clickChangeHistoryReasonByDate(
					dateFormat.format(LocalDate.parse(terminationDate, dateFormat).plusDays(1)), terminationReason);
			changeHistoryPage
					.waitEffectiveAsOf(dateFormat.format(LocalDate.parse(terminationDate, dateFormat).plusDays(1)));
			changeHistoryPage.waitUntilLoadingDisappear();
			*/
			employeePage.assertEventReason(eventReasonFinal);
		}catch(Exception e) {
			System.out.println("Failed to assert");
			throw e;
		}

		/*try {
			adminCenterPage.setSearch(employee);
			fw.timeout(3000);
			//fw.getFullScreenshot();
			adminCenterPage.sendKeyEnterInSearch();
			adminCenterPage.sendKeyEnterInSearch();
		} catch (Exception e) {
			System.out.println("Failed to search");
			throw e;
		}*/
		/*try {
			//employeePage.closeHistory();
			///Thread.sleep(2000);
			employeePage.clickActions();
			Thread.sleep(2000);
			employeePage.clickTermination();
			Thread.sleep(2000);
			terminationPage.sendTerminationDate(terminationDate);
			Thread.sleep(5000);
			employeePage.waitUntilLoadingDisappear();
			terminationPage.selectTerminationReason(terminationReason);
			Thread.sleep(2000);
			terminationPage.selectOkToRehire();
			Thread.sleep(2000);
			terminationPage.clickSaveTermination();

			pleaseConfirmYourRequestPage.setComment(terminationComment);
			pleaseConfirmYourRequestPage.clickShowWorkflowParticipants();
			String[] approvers = pleaseConfirmYourRequestPage.getApprovers();
			pleaseConfirmYourRequestPage.clickConfirm();
			employeePage.waitChangesSavedSuccessfullyDisappear();
			for (int i = 0; i < approvers.length; i++) {
				if (approvers[i] != null) {
					employeePage.proxyNowName(approvers[i]);
					employeePage.approveFirst();
				}
			}
		} catch (Exception e) {
			System.out.println("Failed to terminate contract");
			throw e;
		}*/

	/*
	 * employeePage.sendTerminationComment(terminationComment);
	 * employeePage.clickConfirmTermination(); Thread.sleep(6000);
	 * employeePage.clickTerminationPending(); Thread.sleep(10000);
	 * employeePage.clickViewWorkflow(); String[] approvers =
	 * employeePage.getApprovers(); employeePage.closeWorkflow();
	 * employeePage.dropdownUser(); employeePage.clickProxyNow();
	 * employeePage.selectUserProxy(approvers[0]); employeePage.targetUserOk();
	 * Thread.sleep(13000); employeePage.clickCardApprove();
	 * employeePage.clickApprove();
	 *
	 *
	 * Thread.sleep(3000); if(approvers[1] != null) { employeePage.dropdownUser();
	 * employeePage.clickProxyNow(); employeePage.selectUserProxy(approvers[1]);
	 * employeePage.targetUserOk(); Thread.sleep(13000);
	 * employeePage.clickCardApprove(); employeePage.clickApprove(); }
	 */
	/*
	 * }catch(Exception e) { System.out.println("Failed to terminate contract");
	 * throw e; }
	 */
		}

	@After
	public void close() {

		try {
/*			fw.endTest();*/
		} catch (Exception e) {
			System.out.println("Failed to close test");
			throw e;
		}

	}
	}
